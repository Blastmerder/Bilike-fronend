package com.eveningwithsolovyov.beelike.leaderboard.viewmodels

import androidx.lifecycle.ViewModel
import com.eveningwithsolovyov.beelike.network.data.UserResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LeaderboardViewModel: ViewModel() {
    private val _state = MutableStateFlow(LeaderboardScreenState())
    val state = _state.asStateFlow()
}

data class LeaderboardScreenState(
    val sortedUsers: List<UserResponse> = listOf()
)
