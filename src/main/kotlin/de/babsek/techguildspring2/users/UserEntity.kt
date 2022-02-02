package de.babsek.techguildspring2.users

import javax.persistence.*

@Table(name = "users")
@Entity
data class UserEntity(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "user_name", nullable = false)
    val username: String,

    @Column(name = "first_name", nullable = false)
    val firstName: String,

    @Column(name = "last_name", nullable = false)
    val lastName: String,

    @Column(name = "password", nullable = false)
    val password: String,

    @Column(name = "age")
    val age: Int? = null
)