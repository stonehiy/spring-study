package com.stonehiy.study.shiro

import org.apache.shiro.authc.AuthenticationInfo
import org.apache.shiro.authc.AuthenticationToken
import org.apache.shiro.authc.SimpleAuthenticationInfo
import org.apache.shiro.authz.AuthorizationInfo
import org.apache.shiro.authz.SimpleAuthorizationInfo
import org.apache.shiro.realm.AuthorizingRealm
import org.apache.shiro.subject.PrincipalCollection
import org.apache.shiro.util.ByteSource


/**
 * 自定义realm
 */
class CustomRealm : AuthorizingRealm() {

    private val map = HashMap<String, String>().apply {
        put("Mark", "123456")
        put("Lily", "6a804d292d13f9ecc4dd46dfd8a1dfc1")

    }


    override fun doGetAuthenticationInfo(authenticationToken: AuthenticationToken?): AuthenticationInfo? {

        //从认证信息中获取用户名
        val userName: String = authenticationToken?.principal as String

        //通过用户名获取凭证
        val password = getPasswordByUserName(userName) ?: return null

        return SimpleAuthenticationInfo("Mark", password, "CustomRealm")
                //密码加盐
                .apply {
                    credentialsSalt = ByteSource.Util.bytes("Lily")
                }

    }

    /**
     * 模拟数据库
     */
    private fun getPasswordByUserName(userName: String): String? {
        return map[userName]

    }

    override fun doGetAuthorizationInfo(principalCollection: PrincipalCollection?): AuthorizationInfo? {
        val userName: String = principalCollection?.primaryPrincipal as String
        val roles: Set<String> = getRolesByUserName(userName)
        val permissions: Set<String> = getPermissionsByUserName(userName)

        return SimpleAuthorizationInfo().apply {
            setRoles(roles)
            stringPermissions = permissions
        }

    }

    /**
     * 模拟方法
     */
    private fun getPermissionsByUserName(userName: String): Set<String> {

        return HashSet<String>().apply {
            add("user:add")
        }

    }

    /**
     * 模拟方法
     */
    private fun getRolesByUserName(userName: String): Set<String> {
        return HashSet<String>().apply {
            add("admin")
            add("user")
        }
    }


}