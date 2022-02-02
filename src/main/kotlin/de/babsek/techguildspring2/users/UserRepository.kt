package de.babsek.techguildspring2.users

import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(exported = true, collectionResourceRel = "users", path = "users")
interface UserRepository : CrudRepository<UserEntity, Long> {
    fun existsByUsername(username: String): Boolean
    fun findByUsername(username: String): UserEntity?
    fun deleteByUsername(username: String)
}