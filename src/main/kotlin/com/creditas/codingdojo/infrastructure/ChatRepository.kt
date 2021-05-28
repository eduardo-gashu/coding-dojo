package com.creditas.codingdojo.infrastructure

import com.creditas.codingdojo.domain.Client

class ChatRepository(
    private val chats: MutableSet<Client> = mutableSetOf()
) {


}
