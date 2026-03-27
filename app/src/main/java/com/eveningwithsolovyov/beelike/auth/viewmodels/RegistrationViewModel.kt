package com.eveningwithsolovyov.beelike.auth.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.eveningwithsolovyov.beelike.network.UserRepository
import com.eveningwithsolovyov.beelike.network.data.RegistrationData
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RegistrationViewModel(private val repository: UserRepository): ViewModel() {
    private val _state = MutableStateFlow(RegistrationScreenState())
    val state = _state.asStateFlow()

    private val _events = Channel<RegistrationUiEvent>()
    val events = _events.receiveAsFlow()

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

    fun registerNewUser() {
        viewModelScope.launch {
            updateLoadingState(true)

            if (!_state.value.agreementChecked) {
                updateErrorTextVisibility(true)
                updateLoadingState(false)
                return@launch
            }

            try {
                val result = repository.registerNewUser(
                    RegistrationData(
                        is_admin = 0,
                        username = _state.value.usernameText,
                        phone = ("+" + _state.value.phoneNumberText),
                        password = _state.value.passwordText,
                    )
                )
                if (result.status != "error")
                    _events.send(RegistrationUiEvent.NavigateToApp(result.user_id))
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
    val agreementChecked: Boolean = false,
    val errorTextVisible: Boolean = false,
    val isLoading: Boolean = false
)

sealed class RegistrationUiEvent {
    data class NavigateToApp(val userId: Int = -1): RegistrationUiEvent()
}

