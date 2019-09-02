package spring.core.study.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody


@Controller
class SessionController {


    @GetMapping("testSession")
    @ResponseBody
    fun test(): String {

        return this.toString();

    }
}