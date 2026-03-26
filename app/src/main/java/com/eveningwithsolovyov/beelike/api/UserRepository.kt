package com.eveningwithsolovyov.beelike.api

import com.eveningwithsolovyov.beelike.api.data.LoginData
import com.eveningwithsolovyov.beelike.api.data.RegistrationData
import com.eveningwithsolovyov.beelike.api.data.UserIdResponse

class UserRepository(private val apiService: ApiService) {
    suspend fun loginUser(loginData: LoginData): UserIdResponse {
        return apiService.login(loginData)
    }

    suspend fun registerNewUser(registrationData: RegistrationData): UserIdResponse {
        return apiService.register(registrationData)
    }
}
