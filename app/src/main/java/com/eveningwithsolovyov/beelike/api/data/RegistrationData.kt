package com.eveningwithsolovyov.beelike.api.data

data class RegistrationData(
    val is_admin: Int,
    val password: String,
    val phone: String,
    val username: String
)
