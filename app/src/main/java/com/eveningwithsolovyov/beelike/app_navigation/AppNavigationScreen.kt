package com.eveningwithsolovyov.beelike.app_navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.eveningwithsolovyov.beelike.app_navigation.data.AppNavRoute
import com.eveningwithsolovyov.beelike.app_navigation.data.TOP_LEVEL_DESTINATIONS
import com.eveningwithsolovyov.beelike.navigation.Navigator
import com.eveningwithsolovyov.beelike.app_navigation.ui.components.NavigationContainer
import com.eveningwithsolovyov.beelike.app_navigation.ui.components.NavigationContainerBar
import com.eveningwithsolovyov.beelike.app_navigation.ui.components.NavigationContainerBarItem
import com.eveningwithsolovyov.beelike.app_navigation.viewmodels.AppNavigationViewModel
import com.eveningwithsolovyov.beelike.app_navigation.viewmodels.AppNavigationViewModelFactory
import com.eveningwithsolovyov.beelike.real_events.screens.ActiveEventsScreen
import com.eveningwithsolovyov.beelike.network.RetrofitInstance
import com.eveningwithsolovyov.beelike.network.UserRepository
import com.eveningwithsolovyov.beelike.leaderboard.screens.LeaderboardScreen
import com.eveningwithsolovyov.beelike.navigation.Route
import com.eveningwithsolovyov.beelike.profile.screens.ProfileScreen
import com.eveningwithsolovyov.beelike.ui.theme.ColorSchemeDandelion
import com.eveningwithsolovyov.beelike.ui.theme.TypographyDandelion
import kotlin.collections.component1
import kotlin.collections.component2

@Composable
fun AppNavigationScreen(
    modifier: Modifier = Modifier,
    userId: Int = -1,
    navigator: Navigator? = null
) {
    val repository = UserRepository(RetrofitInstance.api)
    val viewModel: AppNavigationViewModel = viewModel(
        factory = AppNavigationViewModelFactory(repository, userId)
    )

    val state by viewModel.state.collectAsStateWithLifecycle()

    val appNavigationState = rememberAppNavigationState(
        startRoute = AppNavRoute.Profile,
        TOP_LEVEL_DESTINATIONS.keys
    )
    val appNavigator: AppNavigator = remember { AppNavigator(appNavigationState) }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(ColorSchemeDandelion.background)
                .padding(innerPadding)
                .then(modifier),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = state.usernameText,
                    style = TypographyDandelion.headerMedium
                )
                Text(
                    text = state.pointsText,
                    style = TypographyDandelion.headerMedium,
                    textAlign = TextAlign.End
                )
            }
            NavigationContainer(
                navigationBar = {
                    NavigationContainerBar {
                        TOP_LEVEL_DESTINATIONS.forEach { (route, item) ->
                            NavigationContainerBarItem(
                                modifier = Modifier
                                    .weight(2f),
                                onClick = {
                                    appNavigator.navigate(route)
                                },
                                selected = (route == appNavigationState.topLevelRoute),
                                imageVector = item.icon
                            )
                        }
                    }
                }
            ) {
                NavDisplay(
                    modifier = Modifier.fillMaxSize(),
                    onBack = appNavigator::goBack,
                    transitionSpec = {
                        EnterTransition.None togetherWith ExitTransition.None
                    },
                    popTransitionSpec = {
                        EnterTransition.None togetherWith ExitTransition.None
                    },
                    predictivePopTransitionSpec = {
                        EnterTransition.None togetherWith ExitTransition.None
                    },
                    entries = appNavigationState.toEntries(
                        entryProvider = entryProvider {
                            entry<AppNavRoute.Profile> {
                                ProfileScreen(userId = userId)
                            }
                            entry<AppNavRoute.ActiveEvents> {
                                ActiveEventsScreen(
                                    userId = userId,
                                    onBottomButtonClick = {
                                        navigator?.navigate(Route.Registration)
                                    }
                                )
                            }
                            entry<AppNavRoute.Leaderboard> {
                                LeaderboardScreen()
                            }
                        }
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun AppNavigationScreenPreview() {
    AppNavigationScreen()
}
