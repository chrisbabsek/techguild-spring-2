package de.babsek.techguildspring2.users

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@Table(name = "users")
@EntityListeners(AuditingEntityListener::class)
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
    val age: Int? = null,

    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    var createdDate: LocalDateTime? = null,

    @LastModifiedDate
    @Column(name = "last_modified_date", nullable = false)
    var lastModifiedDate: LocalDateTime? = null,

    @Version
    @Column(name = "version", nullable = false)
    var version: Long = 0
)
