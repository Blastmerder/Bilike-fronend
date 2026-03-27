package com.eveningwithsolovyov.beelike.auth.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.eveningwithsolovyov.beelike.network.UserRepository
import com.eveningwithsolovyov.beelike.network.data.LoginData
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: UserRepository
): ViewModel() {
    private val _state = MutableStateFlow(LoginScreenState())
    val state = _state.asStateFlow()

    private val _events = Channel<LoginUiEvent>()
    val events = _events.receiveAsFlow()

    fun updateUsernameText(newValue: String) {
        _state.update { currentState ->
            currentState.copy(usernameText = newValue)
        }
    }

    fun updatePasswordText(newValue: String) {
        _state.update { currentState ->
            currentState.copy(passwordText = newValue)
        }
    }

    fun updateErrorTextVisibility(newValue: Boolean) {
        _state.update { currentState ->
            currentState.copy(errorTextVisible = newValue)
        }
    }

    fun updateLoadingState(newValue: Boolean) {
        _state.update { currentState ->
            currentState.copy(isLoading = newValue)
        }
    }

    fun loginUser() {
        viewModelScope.launch {
            updateLoadingState(true)

            try {
                val result = repository.loginUser(
                    LoginData(
                        username = _state.value.usernameText,
                        password = _state.value.passwordText
                    )
                )
                if (result.status != "error")
                    _events.send(LoginUiEvent.NavigateToApp(result.user_id))
                else {
                    updateErrorTextVisibility(true)
                    updateLoadingState(false)
                }
            } catch (e: Exception) {
                updateErrorTextVisibility(true)
                updateLoadingState(false)
            }
        }
    }
}

class LoginViewModelFactory(private val repository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return LoginViewModel(repository) as T
    }
}

data class LoginScreenState(
    val usernameText: String = "",
    val passwordText: String = "",
    val errorTextVisible: Boolean = false,
    val isLoading: Boolean = false
)

sealed class LoginUiEvent {
    data class NavigateToApp(val userId: Int = -1): LoginUiEvent()
}
