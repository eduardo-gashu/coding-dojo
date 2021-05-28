package com.creditas.codingdojo.infrastructure

import com.creditas.codingdojo.domain.User
import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.`should be null`
import org.junit.jupiter.api.Test

class UserRepositoryTest {
    @Test
    fun `it should find client by id`() {
        val userToBeReturned = User(77, "tester")
        val userToNotBeReturned1 = User(88, "not tester")
        val userToNotBeReturned2 = User(99, "not tester")

        val subject = UserRepository(
            mutableSetOf(userToNotBeReturned1, userToBeReturned, userToNotBeReturned2)
        )

        val result = subject.findById(userToBeReturned.id)

        result `should be equal to` userToBeReturned
    }

    @Test
    fun `it should return null when id is not found`() {
        val userId = 33

        val subject = UserRepository(mutableSetOf())

        val result = subject.findById(userId)

        result.`should be null`()
    }
}
