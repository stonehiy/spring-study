package com.stonehiy.study.shiro

import org.apache.shiro.SecurityUtils
import org.apache.shiro.authc.UsernamePasswordToken
import org.apache.shiro.authc.credential.HashedCredentialsMatcher
import org.apache.shiro.crypto.hash.Md5Hash
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


        //MD5加密
        val hashedCredentialsMatcher = HashedCredentialsMatcher().apply {
            hashAlgorithmName = "md5"
            hashIterations = 1


        }
        customRealm.credentialsMatcher = hashedCredentialsMatcher

        //2.主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager)
        val subject = SecurityUtils.getSubject()

//        val usernamePasswordToken = UsernamePasswordToken("Mark", "123456")
        val usernamePasswordToken = UsernamePasswordToken("Lily", "123456")

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


    @Test
    fun md5Test() {
        val md5Hash = Md5Hash("123456")
        println("md5Hash = ${md5Hash.toString()}")//e10adc3949ba59abbe56e057f20f883e

        val md5Hash1 = Md5Hash("123456", "Lily")
        println("md5Hash1 = ${md5Hash1.toString()}")//6a804d292d13f9ecc4dd46dfd8a1dfc1

    }


}
