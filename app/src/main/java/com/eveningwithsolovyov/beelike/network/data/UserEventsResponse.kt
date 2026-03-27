package com.eveningwithsolovyov.beelike.network.data

data class UserEventsResponse(
    val status: String,
    val events: List<EventResponse>
)
