package de.babsek.techguildspring2

import de.babsek.techguildspring2.users.UserEntity
import de.babsek.techguildspring2.users.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class TestDataInitializer {

    @Autowired
    fun initializeTestData(repository: UserRepository) {
        repository.save(
            UserEntity(username = "ted.tester", firstName = "Ted", lastName = "Tester", password = "secret", age = 25)
        )
    }
}