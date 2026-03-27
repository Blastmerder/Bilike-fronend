package com.eveningwithsolovyov.beelike.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eveningwithsolovyov.beelike.ui.theme.ColorSchemeDandelion
import com.eveningwithsolovyov.beelike.ui.theme.TypographyDandelion

@Composable
fun ButtonDandelion(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    content: @Composable () -> Unit
) {
    ElevatedButton(
        modifier = Modifier
            .height(63.dp)
            .then(modifier),
        onClick = onClick,
        enabled = enabled,
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = ColorSchemeDandelion.primary,
            contentColor = ColorSchemeDandelion.onPrimary,
            disabledContainerColor = ColorSchemeDandelion.primaryDarker,
            disabledContentColor = ColorSchemeDandelion.onPrimary
        ),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
    ) {
        ProvideTextStyle(
            value = TypographyDandelion.buttonText,
            content = content
        )
    }
}

@Preview
@Composable
fun ButtonDandelionPreview() {
    ButtonDandelion(
        onClick = {},
        enabled = false
    ) {
        Text("ВОЙТИ")
    }
}
