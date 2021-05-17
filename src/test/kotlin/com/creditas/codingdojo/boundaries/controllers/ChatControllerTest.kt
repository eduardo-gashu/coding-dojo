package com.creditas.codingdojo.boundaries.controllers

import com.creditas.codingdojo.domain.Chat
import com.fasterxml.jackson.databind.ObjectMapper
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import javax.servlet.http.HttpServletResponse


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ChatControllerTest(
    @Autowired
    private val mockMvc: MockMvc
){
    @Test
    fun `should return 201 for a started chat`() {

        /// usuario
        /// msg


        /// atendente

        val payload = """
            {
               "userId": 2,
               "message": "Hello hello"
            }
        """.trimIndent()


        val c  = mockMvc.perform(
            MockMvcRequestBuilders.post("/chat").content(payload).contentType(MediaType.APPLICATION_JSON)
        ).andExpect {
            it.response.status `should be equal to` HttpServletResponse.SC_CREATED
            it.response.contentAsString `should be equal to` ObjectMapper().writeValueAsString(Chat())
        }
    }


}
