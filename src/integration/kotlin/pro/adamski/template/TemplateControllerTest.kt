package pro.adamski.template

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod.GET
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity

class TemplateControllerTest : IntegrationTestBootstrap() {

    @Test
    fun shouldGetPrintStatement() {
        //given
        val entity: HttpEntity<String> = HttpEntity(null, null)

        //when
        val response: ResponseEntity<String> =
            restTemplate.exchange(getResourceUrl("/template"), GET, entity, String::class.java)

        //then
        assertThat(response.getStatusCode()).isEqualTo(OK)
        assertThat(response.getBody()).isEqualTo("Outside in TDD rocks!")
    }
}