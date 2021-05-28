package com.creditas.codingdojo.infrastructure

import com.creditas.codingdojo.domain.User
import org.springframework.stereotype.Component

@Component
class UserRepository(
    val users: MutableSet<User> = mutableSetOf(
        User(1, "joia"),
        User(2, "carvalho"),
        User(3, "satoshi"),
        User(4, "takeshi")
    )
) {
    fun findById(id: Int): User? {
        return users.find { it.id == id }
    }
}
