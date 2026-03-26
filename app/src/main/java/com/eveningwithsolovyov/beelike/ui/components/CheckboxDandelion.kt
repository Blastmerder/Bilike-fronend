package com.eveningwithsolovyov.beelike.ui.components

import androidx.compose.foundation.Indication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.eveningwithsolovyov.beelike.ui.theme.ColorSchemeDandelion
import com.eveningwithsolovyov.beelike.ui.theme.TypographyDandelion

@Composable
fun CheckboxDandelion(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    headlineContent: @Composable () -> Unit
) {
    Row(
        modifier = Modifier
            .clickable(
                interactionSource = null,
                indication = null
            ) {
                onCheckedChange(!checked)
            }
            .then(modifier),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.weight(1f)
        ) {
            ProvideTextStyle(
                value = TypographyDandelion.headerSmall,
                content = headlineContent
            )
        }
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                checkmarkColor = ColorSchemeDandelion.onPrimary,
                checkedColor = ColorSchemeDandelion.primary,
                uncheckedColor = ColorSchemeDandelion.onBackgroundVariant
            )
        )
    }
}

@Preview
@Composable
fun CheckboxDandelionPreview() {
    CheckboxDandelion(
        headlineContent = {
            Text(
                text = "Я ознакомлен с политикой конфиденциальности"
            )
        },
        checked = true,
        onCheckedChange = {}
    )
}
