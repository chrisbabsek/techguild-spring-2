package de.babsek.techguildspring2.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import java.time.Duration

@ConfigurationProperties(prefix = "tech-guild.config")
@ConstructorBinding
data class CustomConfiguration(
    val findUserDelay: Duration = Duration.ofSeconds(2)
)
