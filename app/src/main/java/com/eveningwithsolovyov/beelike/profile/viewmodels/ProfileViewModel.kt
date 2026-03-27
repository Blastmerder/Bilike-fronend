package com.eveningwithsolovyov.beelike.profile.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.eveningwithsolovyov.beelike.network.UserRepository
import com.eveningwithsolovyov.beelike.network.data.UserIdData
import com.eveningwithsolovyov.beelike.data.UserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val repository: UserRepository,
    private val userId: Int
): ViewModel() {
    private val _state = MutableStateFlow(ProfileScreenState())
    val state = _state.asStateFlow()

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            if (userId == -1)
                return@launch

            try {
                val result = repository.getUserData(UserIdData(id = userId))
                if (result.status != "error") {
                    _state.update { currentState ->
                        currentState.copy(
                            userData = UserData(
                                username = result.username,
                                phoneNumber = result.phone,
                                points = result.points
                            )
                        )
                    }
                }
            } catch (e: Exception) {

            }
        }
    }
}

class ProfileViewModelFactory(
    private val repository: UserRepository,
    private val userId: Int
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return ProfileViewModel(repository, userId) as T
    }
}

data class ProfileScreenState(
    val userData: UserData = UserData()
)
