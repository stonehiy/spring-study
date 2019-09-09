package com.stonehiy.study.stringmvc.controller

import com.stonehiy.study.stringmvc.entity.User
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody


@Controller
class SpringMvcController {


    @RequestMapping(method = [RequestMethod.GET], value = ["/test"])
    fun test(): String {
        //跳转到/views/test.jsp
        println("test .........")
        return "test"
    }


    @RequestMapping(method = [RequestMethod.GET], value = ["/restful"])
    @ResponseBody
    fun restful(): Any {
        val user = User()
        user.age = 1
        user.username = "pack"
        user.password = "123456"
        return user
    }

}