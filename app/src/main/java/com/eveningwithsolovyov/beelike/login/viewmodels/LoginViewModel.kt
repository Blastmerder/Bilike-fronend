package com.eveningwithsolovyov.beelike.login.viewmodels

import androidx.compose.runtime.asIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.eveningwithsolovyov.beelike.api.UserRepository
import com.eveningwithsolovyov.beelike.api.data.LoginData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: UserRepository): ViewModel() {
    private val _state = MutableStateFlow(LoginScreenState())
    val state = _state.asStateFlow()

    private val _userId = mutableIntStateOf(-1)
    val userId = _userId.asIntState()

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

    fun loginUser() {
        viewModelScope.launch {
            val result = repository.loginUser(
                LoginData(
                    username = _state.value.usernameText,
                    password = _state.value.passwordText
                )
            )
            _userId.intValue = result.user_id
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
    val passwordText: String = ""
)
