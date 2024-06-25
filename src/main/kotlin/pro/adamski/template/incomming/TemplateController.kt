package pro.adamski.template

import org.springframework.web.bind.annotation.RestController

@RestController
class TemplateController {

    @GetMapping("/template")
    fun getTemplate(): String {
        return "Hello, World!"
    }
}