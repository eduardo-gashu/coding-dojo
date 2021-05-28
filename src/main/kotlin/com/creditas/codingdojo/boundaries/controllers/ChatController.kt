package com.creditas.codingdojo.boundaries.controllers

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/chat")
class ChatController {
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    fun createChat(): String {


        return """{"chatId":1,"createdBy":1}"""
    }

    companion object {
        const val HELLO_WORLD_MESSAGE = "Hello World!"
    }
}
