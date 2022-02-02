package de.babsek.techguildspring2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.data.web.config.EnableSpringDataWebSupport
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@EnableCaching
//@EnableSpringDataWebSupport
@SpringBootApplication
class TechguildSpring2Application

fun main(args: Array<String>) {
    runApplication<TechguildSpring2Application>(*args)
}
