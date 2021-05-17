package com.creditas.codingdojo.boundaries.controllers

import com.creditas.codingdojo.domain.Chat
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController("/chat")
class ChatController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(): Chat {


        return Chat()
    }
}
