package com.creditas.codingdojo.infrastructure

import com.creditas.codingdojo.domain.Chat
import com.creditas.codingdojo.domain.User
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class ChatRepositoryTest {

    @Autowired
    lateinit var chatRepository: ChatRepository

    @Autowired
    lateinit var clientRepository: ClientRepository

    @Autowired
    lateinit var attendantRepository: AttendantRepository

    @Test
    fun `should persist a Chat`() {

        val client = clientRepository.findById(1)
        val attendant = attendantRepository.findById()


        val chat = Chat(
            id = 1,
            messages = mutableListOf(),
            createdBy = client,

        )


        chatRepository.persits()


    }

}
