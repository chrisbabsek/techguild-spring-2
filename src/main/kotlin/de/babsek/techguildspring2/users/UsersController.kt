package de.babsek.techguildspring2.users

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("users")
@RestController
class UsersController(
    private val userService: UserService
) {
    @GetMapping
    fun findAll(): List<User> {
        return userService.findAll()
    }
}
