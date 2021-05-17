package com.creditas.codingdojo.boundaries.controllers

import com.creditas.codingdojo.domain.Chat
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import javax.servlet.http.HttpServletResponse


@SpringBootTest
class ChatControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `should return 201 for a started chat`() {
        val expectedChat = Chat()

        mockMvc.perform(
            MockMvcRequestBuilders.post("/chat")
        ).andExpect {
            it.response.status `should be equal to` HttpServletResponse.SC_CREATED
            it.response.contentAsString `should be equal to` expectedChat.toString()
        }
    }


}
