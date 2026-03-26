package com.eveningwithsolovyov.beelike.app_navigation

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eveningwithsolovyov.beelike.navigation.Navigator
import com.eveningwithsolovyov.beelike.app_navigation.ui.components.NavigationContainer
import com.eveningwithsolovyov.beelike.ui.theme.ColorSchemeDandelion
import com.eveningwithsolovyov.beelike.ui.theme.TypographyDandelion

@Composable
fun AppNavigationScreen(
    modifier: Modifier = Modifier,
    navigator: Navigator? = null
) {
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
                    text = "@volunteer",
                    style = TypographyDandelion.headerMedium
                )
                Text(
                    text = "15 412",
                    style = TypographyDandelion.headerMedium,
                    textAlign = TextAlign.End
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
