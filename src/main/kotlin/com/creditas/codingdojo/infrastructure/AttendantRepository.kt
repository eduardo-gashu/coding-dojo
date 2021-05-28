package com.creditas.codingdojo.infrastructure

import com.creditas.codingdojo.domain.Attendant
import org.springframework.stereotype.Component

@Component
class AttendantRepository(
    private val attendants: MutableSet<Attendant> = mutableSetOf(
        Attendant(1, "Nurse Joy", 1),
        Attendant(2, "Professor Oak", 2)
    )
) {
    fun findById(id: Int): Attendant? {
        return attendants.find { it.id == id }
    }
}
