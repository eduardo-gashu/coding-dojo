package com.creditas.codingdojo.infrastructure

import com.creditas.codingdojo.domain.Client
import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.`should be null`
import org.junit.jupiter.api.Test

class ClientRepositoryTest {
    @Test
    fun `it should find client by id`() {
        val clientToBeReturned = Client(77, "Test Man", 11)
        val clientToNotBeReturned1 = Client(88, "Wrong Test Man", 22)
        val clientToNotBeReturned2 = Client(99, "Wrong Test Man", 33)

        val subject = ClientRepository(
            mutableSetOf(clientToNotBeReturned1, clientToBeReturned, clientToNotBeReturned2)
        )

        val result = subject.findById(clientToBeReturned.id)

        result `should be equal to` clientToBeReturned
    }

    @Test
    fun `it should return null when id is not found`() {
        val clientId = 33

        val subject = ClientRepository(mutableSetOf())

        val result = subject.findById(clientId)

        result.`should be null`()
    }
}
