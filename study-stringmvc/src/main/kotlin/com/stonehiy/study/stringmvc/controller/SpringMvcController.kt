package com.stonehiy.study.stringmvc.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod


@Controller
class SpringMvcController {



    @RequestMapping(method = [RequestMethod.GET], value = ["/test"])
    fun test(): String {
        //跳转到/views/test.jsp
        println("test .........")
        return "test"
    }

}