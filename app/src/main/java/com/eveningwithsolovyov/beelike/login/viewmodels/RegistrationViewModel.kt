package com.eveningwithsolovyov.beelike.login.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.eveningwithsolovyov.beelike.api.UserRepository
import com.eveningwithsolovyov.beelike.api.data.RegistrationData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RegistrationViewModel(private val repository: UserRepository): ViewModel() {
    private val _state = MutableStateFlow(RegistrationScreenState())
    val state = _state.asStateFlow()

    fun updateUsernameText(newValue: String) {
        _state.update { currentState ->
            currentState.copy(usernameText = newValue)
        }
    }

    fun updatePhoneNumberText(newValue: String) {
        _state.update { currentState ->
            currentState.copy(phoneNumberText = newValue)
        }
    }

    fun updatePasswordText(newValue: String) {
        _state.update { currentState ->
            currentState.copy(passwordText = newValue)
        }
    }

    fun updateAgreementChecked(newValue: Boolean) {
        _state.update { currentState ->
            currentState.copy(agreementChecked = newValue)
        }
    }

    fun registerNewUser() {
        viewModelScope.launch {
            repository.registerNewUser(
                RegistrationData(
                    is_admin = 0,
                    password = _state.value.passwordText,
                    phone = _state.value.phoneNumberText,
                    username = _state.value.usernameText
                )
            )
        }
    }
}

class RegistrationViewModelFactory(private val repository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return RegistrationViewModel(repository) as T
    }
}

data class RegistrationScreenState(
    val usernameText: String = "",
    val phoneNumberText: String = "",
    val passwordText: String = "",
    val agreementChecked: Boolean = false
)
