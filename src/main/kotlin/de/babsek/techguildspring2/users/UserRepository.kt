package de.babsek.techguildspring2.users

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.core.annotation.RestResource

@RepositoryRestResource(exported = true, collectionResourceRel = "users", path = "users")
interface UserRepository : CrudRepository<UserEntity, Long> {
    fun existsByUsername(username: String): Boolean
    fun findByUsername(username: String): UserEntity?
    fun deleteByUsername(username: String)

    @RestResource(rel = "age-at-least", path = "minimum-age")
    fun findByAgeGreaterThanEqual(@Param("minimumAge") age: Int): List<UserEntity>
}
