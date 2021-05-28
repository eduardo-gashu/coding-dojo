package com.creditas.codingdojo.infrastructure

import com.creditas.codingdojo.domain.Chat
import org.springframework.stereotype.Component

@Component
class ChatRepository(
    private val chats: MutableSet<Chat> = mutableSetOf()
) {
    fun persists(chat: Chat) {
        chats.add(chat)
    }
}
