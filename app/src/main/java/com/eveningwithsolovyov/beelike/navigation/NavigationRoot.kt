package com.eveningwithsolovyov.beelike.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.eveningwithsolovyov.beelike.login.screens.LoginScreen
import com.eveningwithsolovyov.beelike.login.screens.RegistrationScreen
import com.eveningwithsolovyov.beelike.app_navigation.AppNavigationScreen

@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier
) {
    val backStack = rememberNavBackStack(Route.Login)
    val navigator = remember { Navigator(backStack = backStack) }

    NavDisplay(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier),
        backStack = backStack,
        onBack = navigator::goBack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        transitionSpec = {
            slideInHorizontally(initialOffsetX = { it }) togetherWith ExitTransition.None
        },
        popTransitionSpec = {
            EnterTransition.None togetherWith slideOutHorizontally(targetOffsetX = { it })
        },
        predictivePopTransitionSpec = {
            EnterTransition.None togetherWith slideOutHorizontally(targetOffsetX = { it })
        },
        entryProvider = entryProvider {
            entry<Route.Login> {
                LoginScreen(navigator = navigator)
            }
            entry<Route.Registration> {
                RegistrationScreen(navigator = navigator)
            }
            entry<Route.AppNavigation> {
                AppNavigationScreen(navigator = navigator)
            }
        }
    )
}