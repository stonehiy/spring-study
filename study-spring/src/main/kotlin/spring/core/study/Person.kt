package spring.core.study

import org.springframework.beans.factory.DisposableBean
import org.springframework.beans.factory.InitializingBean

class Person : InitializingBean, DisposableBean {
    override fun afterPropertiesSet() {
        println("afterPropertiesSet ...")
    }

    override fun destroy() {
        println("destroy ...")
    }

    var name: String? = null
    var age: Int = 0
    var header: Header? = null
    fun initHeader() {
        header?.hairColor = "baise"
    }

    override fun toString(): String {
        return "Person(name=$name, age=$age, header=$header)"
    }


}

