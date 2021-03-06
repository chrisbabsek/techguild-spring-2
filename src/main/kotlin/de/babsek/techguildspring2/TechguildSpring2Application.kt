package de.babsek.techguildspring2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling

@ConfigurationPropertiesScan
@EnableJpaAuditing
@EnableAsync
@EnableCaching
@EnableScheduling
@SpringBootApplication
class TechguildSpring2Application

fun main(args: Array<String>) {
    runApplication<TechguildSpring2Application>(*args)
}