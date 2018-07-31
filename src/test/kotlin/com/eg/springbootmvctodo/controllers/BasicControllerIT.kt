package com.eg.springbootmvctodo.controllers

import com.eg.springbootmvctodo.SpringBootMvcTodoApplication
import org.hamcrest.CoreMatchers.containsString
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes= [(SpringBootMvcTodoApplication::class)],
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BasicControllerIT {
    companion object {
        private const val LOCAL_HOST = "http://localhost:"
    }

    @LocalServerPort
    private lateinit var port: Integer

    private val template = TestRestTemplate()

    @Test
    fun welcome() {
        val response: ResponseEntity<String> = template.getForEntity(
                createUrl("/welcome"), String::class)
        assertThat(response.body, equalTo("Hello, world!"))
    }

    private fun createUrl(uri: String) = LOCAL_HOST + port + uri

    @Test
    fun welcomeWithObject() {
        val response: ResponseEntity<String> =
                template.getForEntity(
                        createUrl("/welcome-with-object"),
                        String::class)
        assertThat(response.body, containsString("Hello, world!"))
    }

    @Test
    fun welcomeWithParameter() {
        val response: ResponseEntity<String> =
                template.getForEntity(
                        createUrl("/welcome-with-parameter/name/Egor"),
                        String::class)
        assertThat(response.body, containsString("Hello World, Egor!"))
    }
}
