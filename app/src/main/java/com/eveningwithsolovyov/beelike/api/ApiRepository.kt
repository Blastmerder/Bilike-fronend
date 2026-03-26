package com.eveningwithsolovyov.beelike.api

import com.eveningwithsolovyov.beelike.api.data.NewUser
import com.eveningwithsolovyov.beelike.api.data.RegisterResponse
import okhttp3.Response

class ApiRepository(private val apiService: ApiService) {
    suspend fun registerNewUser(newUser: NewUser): RegisterResponse {
        return apiService.register(newUser)
    }
}
