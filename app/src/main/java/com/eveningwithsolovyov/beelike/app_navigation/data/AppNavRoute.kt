package com.eveningwithsolovyov.beelike.app_navigation.data

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface AppNavRoute: NavKey {

    @Serializable
    data object Profile: AppNavRoute

    @Serializable
    data object ActiveEvents: AppNavRoute

    @Serializable
    data object Leaderboard: AppNavRoute
}