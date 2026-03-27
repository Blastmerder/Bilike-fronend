package com.eveningwithsolovyov.beelike.app_navigation.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Leaderboard
import androidx.compose.ui.graphics.vector.ImageVector

data class AppNavItem(
    val index: Int,
    val icon: ImageVector
)

val TOP_LEVEL_DESTINATIONS: Map<AppNavRoute, AppNavItem> = mapOf(
    AppNavRoute.Profile to AppNavItem(
        index = 0,
        icon = Icons.Default.AccountCircle
    ),
    AppNavRoute.ActiveEvents to AppNavItem(
        index = 1,
        icon = Icons.AutoMirrored.Default.List
    ),
    AppNavRoute.Leaderboard to AppNavItem(
        index = 2,
        icon = Icons.Default.Leaderboard
    )
)
