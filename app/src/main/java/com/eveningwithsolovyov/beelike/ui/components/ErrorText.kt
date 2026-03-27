package com.eveningwithsolovyov.beelike.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.eveningwithsolovyov.beelike.ui.theme.TypographyDandelion

@Composable
fun ErrorText(
    modifier: Modifier = Modifier,
    visible: Boolean = false,
    text: String
) {
    AnimatedVisibility(
        modifier = Modifier
            .then(modifier),
        visible = visible
    ) {
        Text(
            text = text,
            style = TypographyDandelion.errorText
        )
    }
}

@Preview
@Composable
fun ErrorTextPreview() {
    ErrorText(
        visible = true,
        text = "Ошибка! Проверьте поля ввода"
    )
}
