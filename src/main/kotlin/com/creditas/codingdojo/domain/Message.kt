package com.creditas.codingdojo.domain

import java.time.LocalDateTime

class Message(
    val int: Int,
    val author: User,
    val content: String,
    val createdAt: LocalDateTime
)
