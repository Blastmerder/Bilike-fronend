package com.eveningwithsolovyov.beelike.app_navigation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun NavigationContainerBarItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    color: Color,
    tintColor: Color,
    imageVector: ImageVector
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            .background(color)
            .clickable {
                onClick()
            }
            .padding(8.dp)
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier
                .fillMaxSize(),
            imageVector = imageVector,
            contentDescription = null,
            tint = tintColor
        )
    }
}
