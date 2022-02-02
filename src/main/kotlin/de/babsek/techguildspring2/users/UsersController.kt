package de.babsek.techguildspring2.users

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RequestMapping("users")
@RestController
class UsersController(
    private val userService: UserService
) {
    @GetMapping
    fun findAll(): List<User> {
        return userService.findAll()
    }

    @GetMapping(params = ["username"])
    fun findByUsername(@RequestParam username: String): User {
        return userService.findByUsername(username)
    }

    @PostMapping
    fun createUser(@RequestBody creation: UserCreationDto): ResponseEntity<Unit> {
        return try {
            val id = userService.createUser(
                User(
                    username = "${creation.firstName}.${creation.lastName}",
                    firstName = creation.firstName,
                    lastName = creation.lastName,
                    password = creation.password,
                    age = creation.age?.toUInt()
                )
            )
            ResponseEntity
                .created(URI.create("/users/$id"))
                .build()
        } catch (e: Throwable) {
            ResponseEntity.status(HttpStatus.CONFLICT).build()
        }
    }

    data class UserCreationDto(
        val firstName: String, val lastName: String, val password: String, val age: Int?
    )

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{username}")
    fun deleteByUsername(@PathVariable username: String) {
        return userService.deleteByUsername(username)
    }
}