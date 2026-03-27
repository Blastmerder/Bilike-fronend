package com.eveningwithsolovyov.beelike.network.data

data class RegistrationData(
    val is_admin: Int,
    val username: String,
    val phone: String,
    val password: String
)
