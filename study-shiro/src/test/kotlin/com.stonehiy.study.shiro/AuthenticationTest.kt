package com.stonehiy.study.shiro

import org.apache.shiro.SecurityUtils
import org.apache.shiro.authc.UsernamePasswordToken
import org.apache.shiro.mgt.DefaultSecurityManager
import org.apache.shiro.realm.SimpleAccountRealm
import org.junit.Before
import org.junit.Test

class AuthenticationTest {

    private val simpleAccountRealm = SimpleAccountRealm()

    @Before
    fun addUser() {
        simpleAccountRealm.addAccount("Mark", "123456", "admin")
    }


    @Test
    fun authenticationTest() {

        //1.构建DefaultSecurityManager环境
        val defaultSecurityManager = DefaultSecurityManager()
        defaultSecurityManager.setRealm(simpleAccountRealm)

        //2.主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager)
        val subject = SecurityUtils.getSubject()

        val usernamePasswordToken = UsernamePasswordToken("Mark", "123456")

        //认证，认证失败会抛出异常
        subject.login(usernamePasswordToken)

        println("subject.isAuthenticated = ${subject.isAuthenticated}")

        //角色授权校验，没有这个角色会抛出异常
        subject.checkRole("admin")

//        subject.logout()
//        println("subject.isAuthenticated = ${subject.isAuthenticated}")
    }
}