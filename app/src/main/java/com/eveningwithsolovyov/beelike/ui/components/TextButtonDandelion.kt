package com.eveningwithsolovyov.beelike.ui.components

import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.eveningwithsolovyov.beelike.ui.theme.TypographyDandelion

@Composable
fun TextButtonDandelion(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    TextButton(
        onClick = onClick
    ) {
        ProvideTextStyle(
            value = TypographyDandelion.headerSmall,
            content = content
        )
    }
}

@Preview
@Composable
fun TextButtonDandelionPreview() {
    TextButtonDandelion(
        onClick = {}
    ) {
        Text(text = "НЕТ АККАНУТА? ЗАРЕГИСТРИРУЙТЕСЬ!")
    }
}
