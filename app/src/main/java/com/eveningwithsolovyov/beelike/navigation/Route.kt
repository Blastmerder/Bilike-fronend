package com.eveningwithsolovyov.beelike.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Route: NavKey {

    @Serializable
    data object Login: Route

    @Serializable
    data object Registration: Route

    @Serializable
    data class AppNavigation(val userId: Int): Route

    @Serializable
    data object EventSignUp: Route
}
