package com.creditas.codingdojo.boundaries.controllers

import com.creditas.codingdojo.boundaries.controllers.requests.CreateChatRequest
import com.creditas.codingdojo.domain.Chat
import com.creditas.codingdojo.domain.Client
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/chat")
class ChatController {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: CreateChatRequest): Chat {

        val client = Client(2, "Mario")

        return Chat(client)
    }
}
