package com.creditas.codingdojo.infrastructure

import com.creditas.codingdojo.domain.Attendant
import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.`should be null`
import org.junit.jupiter.api.Test

class AttendantRepositoryTest {
    @Test
    fun `it should find attendant by id`() {
        val attendantToBeReturned = Attendant(77, "Test Man", 11)
        val attendantToNotBeReturned1 = Attendant(88, "Wrong Test Man", 22)
        val attendantToNotBeReturned2 = Attendant(99, "Wrong Test Man", 33)

        val subject = AttendantRepository(
            mutableSetOf(attendantToNotBeReturned1, attendantToBeReturned, attendantToNotBeReturned2)
        )

        val result = subject.findById(attendantToBeReturned.id)

        result `should be equal to` attendantToBeReturned
    }

    @Test
    fun `it should return null when id is not found`() {
        val attendantId = 69

        val subject = AttendantRepository(mutableSetOf())

        val result = subject.findById(attendantId)

        result.`should be null`()
    }
}
