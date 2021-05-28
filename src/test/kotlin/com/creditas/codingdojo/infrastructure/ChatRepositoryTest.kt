package com.creditas.codingdojo.infrastructure

import com.creditas.codingdojo.domain.Chat
import com.creditas.codingdojo.domain.User
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ChatRepositoryTest {

    @Autowired
    lateinit var chatRepository: ChatRepository

    @Autowired
    lateinit var clientRepository: ClientRepository

    @Test
    fun `should persist a Chat`() {

        val client = clientRepository.findById(1)

        val chat = Chat(
            id = 1,
            messages = mutableListOf(),
            createdBy = client!!,
            participants = mutableSetOf()
        )

        chatRepository.persists(chat)
    }
}
