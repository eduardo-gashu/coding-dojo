package com.creditas.codingdojo.infrastructure

import com.creditas.codingdojo.domain.Client
import org.springframework.stereotype.Component

@Component
class ClientRepository(
    private val clients: MutableSet<Client> = mutableSetOf(
        Client(1, "Ash Ketchum", 3),
        Client(2, "Brock", 4)
    )
) {
    fun findById(id: Int): Client? {
        return clients.find { it.id == id }
    }
}
