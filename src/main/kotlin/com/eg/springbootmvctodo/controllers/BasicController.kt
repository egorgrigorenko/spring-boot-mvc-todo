package com.eg.springbootmvctodo.controllers

import com.eg.springbootmvctodo.models.WelcomeBean
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class BasicController {
    private final val helloWorldTemplate = "Hello World, %s!"

    @GetMapping("/welcome")
    fun welcome() = "Hello, world!"

    @GetMapping("/welcome-with-object")
    fun welcomeWithObject() = WelcomeBean("Hello, world!")

    @GetMapping("/welcome-with-parameter/name/{name}")
    fun welcomeWithParameter(@PathVariable name: String) =
            WelcomeBean(String.format(helloWorldTemplate, name))
}
