package pro.adamski.template

import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(
    classes = [TemplateApplication::class],
    value = ["server.port:8023"],
    webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
abstract class IntegrationTestBootstrap {
    var restTemplate = TestRestTemplate()
    fun getResourceUrl(resourceUrl: String): String {
        return "http://localhost:8023$resourceUrl"
    }
}