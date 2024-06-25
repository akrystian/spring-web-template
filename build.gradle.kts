plugins {
	id("org.springframework.boot") version "3.3.1"
	id("io.spring.dependency-management") version "1.1.5"
	kotlin("jvm") version "1.9.24"
	kotlin("plugin.spring") version "1.9.24"
}

group = "pro.adamski"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

configurations {
	create("integrationImplementation") {
		extendsFrom(configurations.implementation.get())
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	developmentOnly("org.springframework.boot:spring-boot-docker-compose")
	implementation("ch.qos.logback:logback-core")
	implementation("org.slf4j:slf4j-simple")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testImplementation("org.assertj:assertj-core")
	testImplementation("com.tngtech.archunit:archunit-junit5:1.0.0")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	"integrationImplementation"(sourceSets["main"].runtimeClasspath)
	"integrationImplementation"(sourceSets["test"].runtimeClasspath)
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

sourceSets {
	create("integration") {
		kotlin.setSrcDirs(listOf("src/integration/kotlin"))
		resources.setSrcDirs(listOf("src/integration/resources"))
		compileClasspath += sourceSets["main"].output + sourceSets["test"].output
		runtimeClasspath += sourceSets["main"].output + sourceSets["test"].output
	}
}

tasks.register<Test>("integrationTest") {
	description = "Runs the integration tests."
	group = "verification"
	testClassesDirs = sourceSets["integration"].output.classesDirs
	classpath = sourceSets["integration"].runtimeClasspath
	useJUnitPlatform()
}

tasks.named("check") {
    dependsOn("integrationTest")
}