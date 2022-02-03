package de.babsek.techguildspring2

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class Scheduled {

    @Scheduled(fixedRate = 2000)
    fun scheduledTask() {
        println("Called")
    }

}