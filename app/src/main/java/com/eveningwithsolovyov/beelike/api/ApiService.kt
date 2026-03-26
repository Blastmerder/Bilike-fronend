package com.eveningwithsolovyov.beelike.api

import com.eveningwithsolovyov.beelike.api.data.LoginData
import com.eveningwithsolovyov.beelike.api.data.RegistrationData
import com.eveningwithsolovyov.beelike.api.data.UserIdResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    suspend fun login(@Body loginData: LoginData): UserIdResponse

    @POST("register")
    suspend fun register(@Body registrationData: RegistrationData): UserIdResponse
}
