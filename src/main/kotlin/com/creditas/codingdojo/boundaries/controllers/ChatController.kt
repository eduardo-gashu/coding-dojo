package com.creditas.codingdojo.boundaries.controllers

import com.creditas.codingdojo.domain.Chat
import org.springframework.web.bind.annotation.PostMapping

class ChatController {

    @PostMapping()
    fun create() {


        return Chat()

    }
}
