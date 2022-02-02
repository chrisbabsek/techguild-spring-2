package de.babsek.techguildspring2

import de.babsek.techguildspring2.configuration.CustomConfiguration
import de.babsek.techguildspring2.users.UserEntity
import de.babsek.techguildspring2.users.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class TestDataInitializer(
    private val config: CustomConfiguration
) {

    @Autowired
    fun initializeTestData(repository: UserRepository) {
        repository.saveAll(
            UserEntity(username = "ted.tester", firstName = "Ted", lastName = "Tester", password = "secret", age = 25),
            UserEntity(username = "anna.berg", firstName = "Anna", lastName = "Berg", password = "secret", age = 64),
            UserEntity(username = "peter.tal", firstName = "Peter", lastName = "Tal", password = "secret", age = 32),
            UserEntity(username = "beate.rauch", firstName = "Beate", lastName = "Rauch", password = "secret")
        )
    }

    @PostConstruct
    fun init() {
        println(config)
    }
}

private fun UserRepository.saveAll(vararg users: UserEntity) = saveAll(users.toList())
