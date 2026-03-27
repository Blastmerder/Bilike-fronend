package com.eveningwithsolovyov.beelike.profile.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProfileViewModel: ViewModel() {
    private val _state = MutableStateFlow(ProfileScreenState())
    val state = _state.asStateFlow()

    fun updateUsernameText(newValue: String) {
        _state.update { currentState ->
            currentState.copy(usernameText = newValue)
        }
    }

    fun updateFullNameText(newValue: String) {
        _state.update { currentState ->
            currentState.copy(fullNameText = newValue)
        }
    }

    fun updatePhoneNumberText(newValue: String) {
        _state.update { currentState ->
            currentState.copy(phoneNumberText = newValue)
        }
    }
}

data class ProfileScreenState(
    val usernameText: String = "",
    val fullNameText: String = "",
    val phoneNumberText: String = ""
)
