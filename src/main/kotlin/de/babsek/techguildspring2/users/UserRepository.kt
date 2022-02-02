package de.babsek.techguildspring2.users

import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.util.*

@RepositoryRestResource(exported = true, collectionResourceRel = "users", path = "users")
interface UserRepository : CrudRepository<UserEntity, UUID>
