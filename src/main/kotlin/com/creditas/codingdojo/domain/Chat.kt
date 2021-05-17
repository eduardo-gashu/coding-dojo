package com.creditas.codingdojo.domain

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

@JsonSerialize
class Chat(
    @JsonProperty
    val client: Client
)