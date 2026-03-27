package com.eveningwithsolovyov.beelike.real_events.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.eveningwithsolovyov.beelike.data.EventData
import com.eveningwithsolovyov.beelike.network.UserRepository
import com.eveningwithsolovyov.beelike.network.data.UserIdData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ActiveEventsViewModel(
    private val repository: UserRepository,
    private val userId: Int
): ViewModel() {
    private val _state = MutableStateFlow(ActiveEventsScreenState())
    val state = _state.asStateFlow()

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            if (userId == -1)
                return@launch

            try {
                val result = repository.getUserEvents(UserIdData(id = userId))
                if (result.status != "error") {
                    _state.update { currentState ->
                        currentState.copy(
                            userEvents = result.events.map {
                                EventData(
                                    name = it.name,
                                    description = it.description,
                                    date = it.date,
                                    attachmentUrl = it.attach
                                )
                            }
                        )
                    }
                }
            } catch (e: Exception) {

            }
        }
    }
}

class ActiveEventsViewModelFactory(
    private val repository: UserRepository,
    private val userId: Int
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return ActiveEventsViewModel(repository, userId) as T
    }
}

data class ActiveEventsScreenState(
    val userEvents: List<EventData> = listOf()
)
