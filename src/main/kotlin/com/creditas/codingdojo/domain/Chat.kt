package com.creditas.codingdojo.domain

class Chat(
    val id: Int,
    val messages: MutableList<Message>,
    val createdBy: Client,
    val participants: MutableSet<User>
)
