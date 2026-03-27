package com.eveningwithsolovyov.beelike.app_navigation.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.eveningwithsolovyov.beelike.ui.theme.ColorSchemeDandelion

@Composable
fun NavigationContainerBarItem(
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    onClick: () -> Unit,
    imageVector: ImageVector
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }
    val isPressed by interactionSource.collectIsPressedAsState()

    val color: Color by animateColorAsState(
        targetValue = if (isPressed || selected) ColorSchemeDandelion.primary else ColorSchemeDandelion.primaryDarker,
        animationSpec = tween(durationMillis = 250, easing = LinearOutSlowInEasing)
    )
    val height: Dp by animateDpAsState(
        targetValue = if (isPressed) 80.dp else 48.dp,
        animationSpec = tween(durationMillis = 250, easing = LinearOutSlowInEasing)
    )
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            .background(color)
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                onClick()
            }
            .padding(8.dp)
            .height(height)
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier
                .fillMaxSize(),
            imageVector = imageVector,
            contentDescription = null,
            tint = ColorSchemeDandelion.onPrimary
        )
    }
}
