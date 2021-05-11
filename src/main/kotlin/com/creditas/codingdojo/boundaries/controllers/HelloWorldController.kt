package com.creditas.codingdojo.boundaries.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello-world")
class HelloWorldController {
    @GetMapping
    fun helloWorld(): String {
        return HELLO_WORLD_MESSAGE
    }

    companion object {
        const val HELLO_WORLD_MESSAGE = "Hello World!"
    }
}
