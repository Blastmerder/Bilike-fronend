package com.eveningwithsolovyov.beelike.network.data

data class UserResponse(
    val status: String,
    val username: String = "",
    val phone: String = "",
    val points: Int = 0,
    val event: List<Int> = listOf(),
    val list_task: List<Int> = listOf()
)
