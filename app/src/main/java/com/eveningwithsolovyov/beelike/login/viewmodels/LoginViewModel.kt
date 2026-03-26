package com.eveningwithsolovyov.beelike.login.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel: ViewModel() {
    private val _state = MutableStateFlow(LoginScreenState())
    val state = _state.asStateFlow()

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
}

data class LoginScreenState(
    val usernameText: String = "",
    val passwordText: String = ""
)
