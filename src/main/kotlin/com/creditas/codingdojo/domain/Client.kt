package com.creditas.codingdojo.domain

import com.fasterxml.jackson.databind.annotation.JsonSerialize

@JsonSerialize
class Client(
    val id: Int,
    val name: String
)