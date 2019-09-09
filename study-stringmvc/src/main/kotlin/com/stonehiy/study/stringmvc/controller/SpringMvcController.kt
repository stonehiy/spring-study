package com.stonehiy.study.stringmvc.controller

import com.stonehiy.study.stringmvc.entity.Error
import com.stonehiy.study.stringmvc.entity.Result
import com.stonehiy.study.stringmvc.entity.User
import org.apache.commons.logging.LogFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody


@Controller
class SpringMvcController {
    val logger = LogFactory.getLog(SpringMvcController::class.java)


    @RequestMapping(value = ["/test"], method = [RequestMethod.GET])
    fun test(): String {
        //跳转到/views/test.jsp
        logger.info("test .........")
        return "test"
    }


    @RequestMapping(value = ["/restful"], method = [RequestMethod.GET])
    @ResponseBody
    fun restful(): Any {
        val user = User().apply {
            age = 1
            username = "pack"
            password = "123456"
        }
        logger.info("restful .........$user")
        return Result.onSuccess(user)
    }


    @RequestMapping(value = ["/postTest"], method = [RequestMethod.POST])
    @ResponseBody
    fun postTest(): Any {
        return Result.onFail<Any>(Error.ON_FAIL)
    }


    @RequestMapping(value = ["/deleteTest"], method = [RequestMethod.DELETE])
    @ResponseBody
    fun deleteTest(): Any {

        return Result.onFail<Any>(Error.ON_FAIL)
    }

}