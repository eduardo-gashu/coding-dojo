package com.creditas.codingdojo.boundaries.controllers

import com.creditas.codingdojo.infrastructure.ClientRepository
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ChatControllerTest(
    @Autowired val mockMvc: MockMvc,

    @Autowired val clientRepository: ClientRepository
) {
    @Test
    fun `it should return HTTP_CREATED with chat id`() {
        val result = mockMvc.post("/chat")
            .andExpect { status { isCreated() } }
            .andReturn()

        result.response.contentAsString `should be equal to` "123"
    }

    @Test
    fun `it should create a chat create by the received client`() {
        val client = clientRepository.findById(1)

        val payload = """
            {
                "client_id": ${client!!.id}
            }
        """.trimIndent()

        val result = mockMvc.post("/chat")
            .andExpect { status { isCreated() } }
            .andReturn()

        result.response.contentAsString `should be equal to` "123"
    }
}
