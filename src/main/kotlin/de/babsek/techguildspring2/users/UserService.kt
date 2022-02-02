package de.babsek.techguildspring2.users

import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@CacheConfig(cacheNames = ["users"])
@Service
class UserService(
    private val repository: UserRepository
) {
    fun findAll(): List<User> {
        return repository
            .findAll()
            .map { it.toDomainObject() }
    }

    fun countAll(): Long {
        return repository.count()
    }

    @Cacheable
    fun findByUsername(username: String): User {
        Thread.sleep(2000)
        return repository.findByUsername(username)?.toDomainObject() ?: error("No user $username found!")
    }

    fun updateUserByUsername(username: String, updateBlock: User.() -> User) {
        repository
            .findByUsername(username)
            ?.let { it.patch(it.toDomainObject().updateBlock()) }
            ?.let(repository::save)
            ?: error("No user $username found!")
    }

    @Transactional
    @CacheEvict
    fun deleteByUsername(username: String) {
        require(repository.existsByUsername(username)) { "No such user: $username" }
        repository.deleteByUsername(username)
    }

    fun createUser(user: User): Long {
        val actualUsername = "${user.firstName}.${user.lastName}".lowercase()
        return when (repository.existsByUsername(actualUsername)) {
            true -> error("Another user '$actualUsername' already existing.")
            false -> repository.save(user.copy(username = actualUsername).toEntity()).id ?: error("No ID created.")
        }
    }
}

fun UserEntity.toDomainObject() = User(
    username = username,
    firstName = firstName,
    lastName = lastName,
    password = password,
    age = age?.toUInt()
)

fun UserEntity.patch(user: User) = copy(
    username = user.username,
    firstName = user.firstName,
    lastName = user.lastName,
    password = user.password,
    age = user.age?.toInt()
)

fun User.toEntity() = UserEntity(
    username = username,
    firstName = firstName,
    lastName = lastName,
    password = password,
    age = age?.toInt()
)
