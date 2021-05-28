package com.creditas.codingdojo.boundaries.controllers

import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ClientControllerTest(
    @Autowired
    val mockMvc: MockMvc
) {
    @Test
    fun `it should return HTTP_CREATED with chat id`() {
        val result = mockMvc.post("/create-chat")
            .andExpect { status { isCreated() } }
            .andReturn()

        result.response.contentAsString `should be equal to` 1
    }

    @Test
    fun `it should return HTTP_OK with hello world message`() {
        val data = """
            {
                "text": "hello",
                "chatId", 1
            }
        """.trimIndent();

        val result = mockMvc.post("/message", data)
            .andExpect { status { is2xxSuccessful() } }
            .andReturn()

        result.response.contentAsString `should be equal to` "Hello World!"
    }
}
