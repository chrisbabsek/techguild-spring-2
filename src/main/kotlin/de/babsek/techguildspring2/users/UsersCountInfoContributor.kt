package de.babsek.techguildspring2.users

import org.springframework.boot.actuate.info.Info
import org.springframework.boot.actuate.info.InfoContributor
import org.springframework.stereotype.Component

@Component
class UsersCountInfoContributor(private val usersService: UserService) : InfoContributor {
    override fun contribute(builder: Info.Builder) {
        builder
            .withDetail("usersCount", usersService.countAll())
            .build()
    }
}