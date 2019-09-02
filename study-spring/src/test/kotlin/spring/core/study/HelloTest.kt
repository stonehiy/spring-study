package spring.core.study

import org.junit.Before
import org.junit.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.support.AbstractApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext
import spring.core.study.config.MyConfiguration

class HelloTest {


    @Before
    fun init() {

    }


    @Test
    fun xmlTest() {

//        val person = Person("Lily", 20)
//        print("person = $person")

//        val context = ClassPathXmlApplicationContext("spring.xml")
        val context: AbstractApplicationContext = ClassPathXmlApplicationContext("spring.xml")
        val person: Person = context.getBean("person") as Person
        println("person = $person")
        context.close()


    }

    @Test
    fun configurationTest() {
        val context = AnnotationConfigApplicationContext(MyConfiguration::class.java)
        val person = context.getBean("getPerson", Person::class.java)
        println("person = $person")

    }

}
