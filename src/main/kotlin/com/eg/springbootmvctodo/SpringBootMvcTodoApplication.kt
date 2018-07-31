package com.eg.springbootmvctodo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootMvcTodoApplication

fun main(args: Array<String>) {
    val ctx = runApplication<SpringBootMvcTodoApplication>(*args)
    val beanNames = ctx.beanDefinitionNames
    beanNames.sort()
    beanNames.forEach(::println)
}
