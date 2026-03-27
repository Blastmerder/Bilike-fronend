package com.eveningwithsolovyov.beelike.network.data

data class RankedUserResponse(
    val id: Int,
    val points: Int,
    val rank: Int,
    val username: String
)
