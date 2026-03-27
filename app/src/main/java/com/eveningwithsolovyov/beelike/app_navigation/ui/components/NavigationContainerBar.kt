package com.eveningwithsolovyov.beelike.app_navigation.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eveningwithsolovyov.beelike.app_navigation.data.AppNavRoute
import com.eveningwithsolovyov.beelike.app_navigation.data.TOP_LEVEL_DESTINATIONS
import com.eveningwithsolovyov.beelike.ui.theme.ColorSchemeDandelion

@Composable
fun NavigationContainerBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .then(modifier),
        verticalAlignment = Alignment.Bottom
    ) {
        content()
        Spacer(modifier = Modifier.weight(1f))
    }
}

val ITEM_LEVEL_COLORS = listOf(
    ColorSchemeDandelion.primary,
    ColorSchemeDandelion.primaryDarker,
    ColorSchemeDandelion.primaryDark
)

@Preview
@Composable
fun NavigationContainerBarPreview() {
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
