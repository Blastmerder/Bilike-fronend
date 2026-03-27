package com.eveningwithsolovyov.beelike.network

import com.eveningwithsolovyov.beelike.network.data.LoginData
import com.eveningwithsolovyov.beelike.network.data.RegistrationData
import com.eveningwithsolovyov.beelike.network.data.UserIdData
import com.eveningwithsolovyov.beelike.network.data.UserIdResponse
import com.eveningwithsolovyov.beelike.network.data.UserResponse
import retrofit2.Response

class UserRepository(private val apiService: ApiService) {
    suspend fun loginUser(loginData: LoginData): UserIdResponse {
        return apiService.login(loginData).body() ?: UserIdResponse(
            status = "error",
            user_id = -1
        )
    }

    suspend fun registerNewUser(registrationData: RegistrationData): UserIdResponse {
        return apiService.register(registrationData).body() ?: UserIdResponse(
            status = "error",
            user_id = -1
        )
    }

    suspend fun getUserData(userIdData: UserIdData): UserResponse {
        return apiService.getData(userIdData).body() ?: UserResponse(
            status = "error"
        )
    }
}
