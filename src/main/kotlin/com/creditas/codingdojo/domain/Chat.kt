package com.creditas.codingdojo.domain

class Chat(
    val id: Int,
    val messages: MutableList<Message>,
    val createdBy: User,
    val participants: MutableSet<User>
)
