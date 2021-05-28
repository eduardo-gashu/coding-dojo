package com.creditas.codingdojo.boundaries.controllers

import com.creditas.codingdojo.infrastructure.ChatRepository
import com.creditas.codingdojo.infrastructure.ClientRepository
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ChatControllerTest(
    @Autowired val mockMvc: MockMvc,

    @Autowired val clientRepository: ClientRepository,

    @Autowired val chatRepository: ChatRepository
) {
    @Test
    fun `it should create a chat create by the received client`() {
        val client = clientRepository.findById(1)

        val payload = """
            {
                "clientId": ${client!!.id}
            }
        """.trimIndent()

        val result = mockMvc.perform(
            MockMvcRequestBuilders.post("/chat")
            .contentType(MediaType.APPLICATION_JSON)
            .content(payload)
        )
            .andExpect { MockMvcResultMatchers.status().isCreated }
            .andReturn()

        chatRepository.findById(1)

        val expectedResponse = """{"chatId":1,"createdBy":1}"""

        result.response.contentAsString `should be equal to` expectedResponse
    }
}
