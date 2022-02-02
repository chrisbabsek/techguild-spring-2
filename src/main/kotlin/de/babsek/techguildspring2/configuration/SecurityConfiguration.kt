package de.babsek.techguildspring2.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
class SecurityConfiguration {

    @Bean
    fun securityDisabled(): WebSecurityConfigurerAdapter = object : WebSecurityConfigurerAdapter() {
        override fun configure(http: HttpSecurity) {
            http
                .authorizeRequests()
                .anyRequest()
                .permitAll()
                .and()
                .csrf()
                .disable()
        }
    }
}
