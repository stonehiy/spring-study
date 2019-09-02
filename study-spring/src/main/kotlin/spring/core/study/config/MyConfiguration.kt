package spring.core.study.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import spring.core.study.Person


@Configuration
open class MyConfiguration {


    @Bean(value = "getPerson")
    open fun getPerson(): Person {
        return Person()
    }
}