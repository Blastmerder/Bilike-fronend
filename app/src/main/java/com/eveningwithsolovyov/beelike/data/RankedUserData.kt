package com.eveningwithsolovyov.beelike.data

data class RankedUserData(
    val userId: Int = -1,
    val username: String = "USERNAME",
    val rank: Int = 0,
    val points: Int = 0
)