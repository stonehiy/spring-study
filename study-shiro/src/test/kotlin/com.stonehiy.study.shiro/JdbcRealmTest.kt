package com.stonehiy.study.shiro

import com.alibaba.druid.pool.DruidDataSource
import org.apache.shiro.SecurityUtils
import org.apache.shiro.authc.UsernamePasswordToken
import org.apache.shiro.mgt.DefaultSecurityManager
import org.apache.shiro.realm.jdbc.JdbcRealm
import org.junit.Test

class JdbcRealmTest {

    private val druidDataSource = DruidDataSource().apply {
        url = "jdbc:mysql://192.168.56.101:3306/test"
        username = "root"
        password = "root"
    }


    @Test
    fun jdbcRealmTest() {

        //
        val jdbcRealm = JdbcRealm()
        //设置jdbcRealm的数据源
        jdbcRealm.setDataSource(druidDataSource)
        jdbcRealm.setPermissionsLookupEnabled(true)

        //1.构建DefaultSecurityManager环境
        val defaultSecurityManager = DefaultSecurityManager()
        defaultSecurityManager.setRealm(jdbcRealm)

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
        subject.checkPermission("user:delete")
        subject.checkPermission("user:update")

//        subject.logout()
//        println("subject.isAuthenticated = ${subject.isAuthenticated}")

    }
}