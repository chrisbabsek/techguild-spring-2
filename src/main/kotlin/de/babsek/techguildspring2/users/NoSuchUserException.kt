package de.babsek.techguildspring2.users

class NoSuchUserException(username: String) : RuntimeException(
    "No such user: $username"
)
