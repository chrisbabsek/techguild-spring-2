package de.babsek.techguildspring2.users

data class User(
    val username: String,
    val firstName: String,
    val lastName: String,
    val password: String,
    val age: UInt? = null
) {
    fun getAgeString() = age?.toString() ?: "-"
}
