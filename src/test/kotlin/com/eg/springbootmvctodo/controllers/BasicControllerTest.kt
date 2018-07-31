package com.eg.springbootmvctodo.controllers

import org.hamcrest.CoreMatchers.containsString
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner::class)
@WebMvcTest(BasicController::class)
class BasicControllerTest {
    @Autowired
    private lateinit var mvc: MockMvc

    @Test
    fun welcome() {
        mvc.perform(MockMvcRequestBuilders.get("/welcome")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().string(equalTo("Hello, world!")))
    }

    @Test
    fun welcomeWithObject() {
        mvc.perform(
                MockMvcRequestBuilders.get("/welcome-with-object")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content()
                        .string(containsString("Hello, world!")))
    }

    @Test
    fun welcomeWithParameter() {
        mvc.perform(
                MockMvcRequestBuilders.get("/welcome-with-parameter/name/Egor")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().string(containsString("Hello World, Egor!")))
    }
}
