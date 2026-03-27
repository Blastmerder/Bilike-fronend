package com.eveningwithsolovyov.beelike.events.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eveningwithsolovyov.beelike.R
import com.eveningwithsolovyov.beelike.ui.theme.ColorSchemeDandelion
import com.eveningwithsolovyov.beelike.ui.theme.TypographyDandelion

@Composable
fun EventCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable () -> Unit,
    text: @Composable () -> Unit,
    supportingText: @Composable () -> Unit
) {
    Card(
        modifier = Modifier
            .width(180.dp)
            .clickable {
                onClick()
            }
            .then(modifier),
        colors = CardDefaults.cardColors(
            containerColor = ColorSchemeDandelion.primaryDark
        )
    ) {
        content()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            ProvideTextStyle(
                value = TypographyDandelion.cardText
            ) {
                text()
            }

            Spacer(modifier = Modifier.height(8.dp))
            ProvideTextStyle(
                value = TypographyDandelion.cardSupportingText
            ) {
                supportingText()
            }
        }
    }
}

@Preview
@Composable
fun EventCardPreview() {
    EventCard(
        onClick = {},
        content = {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(R.drawable.card_placeholder_1),
                contentDescription = null
            )
        },
        text = {
            Text(text = "Лекция", fontSize = 16.sp)
        },
        supportingText = {
            Text(text = "Дата добавления:\n27/03/2026", fontSize = 14.sp, lineHeight = 20.sp)
        }
    )
}
