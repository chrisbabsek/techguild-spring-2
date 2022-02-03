package de.babsek.techguildspring2.users

import com.fasterxml.jackson.annotation.JsonIgnore


data class User(
    val username: String,
    val firstName: String,
    val lastName: String,
    val password: String,
    val age: UInt? = null
) {

    @JsonIgnore
    fun getAgeString() = age?.toString() ?: "-"
}