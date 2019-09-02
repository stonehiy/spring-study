package spring.core.study.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody


@Controller
class RequestController {


    @GetMapping("testRequest")
    @ResponseBody
    fun test(): String {

        return this.toString();

    }

    @GetMapping("/")
    @ResponseBody
    fun test1(): String {
        return "test"

    }
}