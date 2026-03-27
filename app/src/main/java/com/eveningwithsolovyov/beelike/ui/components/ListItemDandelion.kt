package com.eveningwithsolovyov.beelike.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eveningwithsolovyov.beelike.ui.theme.ColorSchemeDandelion

@Composable
fun ListItemDandelion(
    modifier: Modifier = Modifier,
    leadingText: @Composable () -> Unit,
    trailingText: @Composable () -> Unit
) {
    ListItem(
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .then(modifier),
        headlineContent = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ProvideTextStyle(value = TextStyle(textAlign = TextAlign.Start)) {
                    leadingText()
                }
                ProvideTextStyle(value = TextStyle(textAlign = TextAlign.End)) {
                    trailingText()
                }
            }
        },
        colors = ListItemDefaults.colors(
            containerColor = ColorSchemeDandelion.surface,
            headlineColor = ColorSchemeDandelion.onSurface
        )
    )
}

@Preview
@Composable
fun ListItemDandelionPreview() {
    ListItemDandelion(
        leadingText = {
            Text(text = "Павлов Тимур Сергеевич")
        },
        trailingText = {
            Text(text = "1 488")
        }
    )
}