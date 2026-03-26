package com.eveningwithsolovyov.beelike.api.data

data class NewUser(
    val is_admin: Int,
    val password: String,
    val phone: String,
    val username: String
)
