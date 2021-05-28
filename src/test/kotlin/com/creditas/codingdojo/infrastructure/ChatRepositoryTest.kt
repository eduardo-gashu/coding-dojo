package com.creditas.codingdojo.infrastructure

import com.creditas.codingdojo.domain.Chat
import org.amshove.kluent.`should be equal to`
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

    @Test
    fun `#findById will return a chat`() {
        val client = clientRepository.findById(1)

        val chat = Chat(
            id = 1,
            messages = mutableListOf(),
            createdBy = client!!,
            participants = mutableSetOf()
        )

        chatRepository.persists(chat)

        val chatResult = chatRepository.findById(chat.id)

        chatResult `should be equal to` chat
    }
}
