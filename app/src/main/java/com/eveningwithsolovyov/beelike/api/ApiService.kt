package com.eveningwithsolovyov.beelike.api

import com.eveningwithsolovyov.beelike.api.data.NewUser
import com.eveningwithsolovyov.beelike.api.data.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("register")
    suspend fun register(@Body newUser: NewUser): Result<RegisterResponse>
}