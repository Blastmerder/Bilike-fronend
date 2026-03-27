package com.eveningwithsolovyov.beelike.leaderboard.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.eveningwithsolovyov.beelike.data.RankedUserData
import com.eveningwithsolovyov.beelike.network.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LeaderboardViewModel(private val repository: UserRepository): ViewModel() {
    private val _state = MutableStateFlow(LeaderboardScreenState())
    val state = _state.asStateFlow()

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            try {
                val result = repository.getRankedUsersData()
                _state.update { currentState ->
                    currentState.copy(
                        sortedUsers = result.map {
                            RankedUserData(
                                userId = it.id,
                                username = it.username,
                                points = it.points,
                                rank = it.rank
                            )
                        }
                    )
                }
            } catch (e: Exception) {

            }
        }
    }
}

class LeaderboardViewModelFactory(
    private val repository: UserRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return LeaderboardViewModel(repository) as T
    }
}

data class LeaderboardScreenState(
    val sortedUsers: List<RankedUserData> = listOf()
)
