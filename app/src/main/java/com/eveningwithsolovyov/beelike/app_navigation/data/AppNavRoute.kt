package com.eveningwithsolovyov.beelike.app_navigation.data

import kotlinx.serialization.Serializable

@Serializable
sealed interface AppNavRoute {

    @Serializable
    data object Profile: AppNavRoute

    @Serializable
    data object ActiveEvents: AppNavRoute

    @Serializable
    data object Leaderboard: AppNavRoute
}