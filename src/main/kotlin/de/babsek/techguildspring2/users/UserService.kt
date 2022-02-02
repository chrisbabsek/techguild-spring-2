package de.babsek.techguildspring2.users

import org.springframework.stereotype.Service

@Service
class UserService(
    private val repository: UserRepository
) {
    val user = User("ted.tester", "Ted", "Tester", "secret", 25u)

    fun findAll(): List<User> {
        repository.findAll()
        return listOf(user)
    }
}
