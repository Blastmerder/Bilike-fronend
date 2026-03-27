package com.eveningwithsolovyov.beelike.app_navigation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.eveningwithsolovyov.beelike.app_navigation.data.AppNavRoute
import com.eveningwithsolovyov.beelike.app_navigation.data.TOP_LEVEL_DESTINATIONS
import com.eveningwithsolovyov.beelike.ui.theme.ColorSchemeDandelion

@Composable
fun NavigationContainer(
    modifier: Modifier = Modifier,
    navigationBar: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier)
    ) {
        navigationBar()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(ColorSchemeDandelion.primary)
                .weight(1f)
        ) {
            content()
        }
    }
}

@Preview
@Composable
fun NavigationContainerPreview() {
    NavigationContainer(
        navigationBar = {
            NavigationContainerBar {
                TOP_LEVEL_DESTINATIONS.forEach { (route, item) ->
                    NavigationContainerBarItem(
                        modifier = Modifier
                            .weight(2f),
                        onClick = {},
                        selected = (route == AppNavRoute.Profile),
                        imageVector = item.icon
                    )
                }
            }
        }
    ) {}
}
