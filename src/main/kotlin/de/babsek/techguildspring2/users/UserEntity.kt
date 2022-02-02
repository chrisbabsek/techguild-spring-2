package de.babsek.techguildspring2.users

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class UserEntity(
    @Id
    val id: UUID? = null,
    @Column(name = "user_name")
    val username: String
)
