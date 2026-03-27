package com.eveningwithsolovyov.beelike.network

import com.eveningwithsolovyov.beelike.network.data.LoginData
import com.eveningwithsolovyov.beelike.network.data.RegistrationData
import com.eveningwithsolovyov.beelike.network.data.UserIdData
import com.eveningwithsolovyov.beelike.network.data.UserIdResponse
import com.eveningwithsolovyov.beelike.network.data.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    suspend fun login(@Body loginData: LoginData): Response<UserIdResponse>

    @POST("register")
    suspend fun register(@Body registrationData: RegistrationData): Response<UserIdResponse>

    @POST("get_data")
    suspend fun getData(@Body userIdData: UserIdData): Response<UserResponse>
}
