package pro.adamski.template

import IntegrationTestBootstrap
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TemplateControllerTest : IntegrationTestBootstrap() {

        @Test
        fun `should return template`(){
            //given
            val templateController = TemplateController()
            //when
            val template = templateController.getTemplate()
            //then
            assertEquals("template", template)
        }
}