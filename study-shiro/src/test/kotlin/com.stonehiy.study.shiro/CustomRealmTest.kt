package com.stonehiy.study.shiro

import org.apache.shiro.SecurityUtils
import org.apache.shiro.authc.UsernamePasswordToken
import org.apache.shiro.mgt.DefaultSecurityManager
import org.junit.Test

class CustomRealmTest {


    @Test
    fun customRealmTest() {

        //
        val customRealm = CustomRealm()


        //1.构建DefaultSecurityManager环境
        val defaultSecurityManager = DefaultSecurityManager()
        defaultSecurityManager.setRealm(customRealm)

        //2.主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager)
        val subject = SecurityUtils.getSubject()

        val usernamePasswordToken = UsernamePasswordToken("Mark", "123456")

        //认证，认证失败会抛出异常
        subject.login(usernamePasswordToken)

        println("subject.isAuthenticated = ${subject.isAuthenticated}")

        //角色授权校验，没有这个角色会抛出异常
        subject.checkRole("admin")

        //角色权限验证,没有权限会抛出异常
//        subject.checkPermission("user:delete")
//        subject.checkPermission("user:update")
        subject.checkPermission("user:add")

//        subject.logout()
//        println("subject.isAuthenticated = ${subject.isAuthenticated}")

    }
}