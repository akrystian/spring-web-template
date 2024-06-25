package pro.adamski.template.incomming

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TemplateController {

    @GetMapping("/template")
    fun getTemplate(): String {
        return "Outside in TDD rocks!"
    }
}