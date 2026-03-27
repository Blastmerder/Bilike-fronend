package com.eveningwithsolovyov.beelike.app_navigation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.eveningwithsolovyov.beelike.network.UserRepository
import com.eveningwithsolovyov.beelike.network.data.UserIdData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AppNavigationViewModel(
    private val repository: UserRepository,
    private val userId: Int
): ViewModel() {
    private val _state = MutableStateFlow(AppNavigationScreenState())
    val state = _state.asStateFlow()

    init {
        fetchData()
    }

    fun updateUserInfo(newUsernameText: String, newPointsText: String) {
        _state.update { currentState ->
            currentState.copy(
                usernameText = newUsernameText,
                pointsText = newPointsText
            )
        }
    }

    fun fetchData() {
        viewModelScope.launch {
            if (userId == -1)
                return@launch

            try {
                val result = repository.getUserData(UserIdData(id = userId))
                if (result.status != "error") {
                    updateUserInfo(
                        newUsernameText = result.username,
                        newPointsText = result.points.toString()
                    )
                }
            } catch (e: Exception) {

            }
        }
    }
}

class AppNavigationViewModelFactory(
    private val repository: UserRepository,
    private val userId: Int
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return AppNavigationViewModel(repository, userId) as T
    }
}

data class AppNavigationScreenState(
    val usernameText: String = "@username",
    val pointsText: String = "0"
)
