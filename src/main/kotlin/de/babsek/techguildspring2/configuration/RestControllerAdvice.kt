package de.babsek.techguildspring2.configuration

import de.babsek.techguildspring2.users.NoSuchUserException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class RestErrorConfiguration {

    @ExceptionHandler(NoSuchUserException::class)
    fun handler(ex: NoSuchUserException): ResponseEntity<String> {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(ex.message)
    }
}
