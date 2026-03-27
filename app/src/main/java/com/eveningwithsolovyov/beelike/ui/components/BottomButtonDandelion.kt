package com.eveningwithsolovyov.beelike.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eveningwithsolovyov.beelike.ui.theme.ColorSchemeDandelion
import com.eveningwithsolovyov.beelike.ui.theme.TypographyDandelion

@Composable
fun BottomButtonDandelion(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Button(
        modifier = Modifier
            .height(63.dp)
            .then(modifier),
        onClick = onClick,
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = ColorSchemeDandelion.surface,
            contentColor = ColorSchemeDandelion.onSurfaceDark
        )
    ) {
        ProvideTextStyle(
            value = TypographyDandelion.bottomButtonText,
            content = content
        )
    }
}

@Preview
@Composable
fun BottomButtonDandelionPreview() {
    BottomButtonDandelion(
        onClick = {}
    ) {
        Text(text = "Записаться на мероприятие")
    }
}
