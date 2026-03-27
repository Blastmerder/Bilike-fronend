package com.eveningwithsolovyov.beelike.events.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eveningwithsolovyov.beelike.R
import com.eveningwithsolovyov.beelike.events.ui.components.EventCard

@Composable
fun ActiveEventsScreen(
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp)
            .then(modifier),
        columns = GridCells.Fixed(count = 2),
        contentPadding = PaddingValues(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
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
                    Text(text = "Лекция")
                },
                supportingText = {
                    Text(text = "Дата добавления:\n27/03/2026")
                }
            )
        }
        item {
            EventCard(
                onClick = {},
                content = {
                    Image(
                        modifier = Modifier.fillMaxWidth(),
                        painter = painterResource(R.drawable.card_placeholder_2),
                        contentDescription = null
                    )
                },
                text = {
                    Text(text = "Хуекция")
                },
                supportingText = {
                    Text(text = "Дата добавления:\n28/03/2026")
                }
            )
        }
        item {
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
                    Text(text = "Лекция")
                },
                supportingText = {
                    Text(text = "Дата добавления:\n27/03/2026")
                }
            )
        }
        item {
            EventCard(
                onClick = {},
                content = {
                    Image(
                        modifier = Modifier.fillMaxWidth(),
                        painter = painterResource(R.drawable.card_placeholder_2),
                        contentDescription = null
                    )
                },
                text = {
                    Text(text = "Хуекция")
                },
                supportingText = {
                    Text(text = "Дата добавления:\n28/03/2026")
                }
            )
        }
        item {
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
                    Text(text = "Лекция")
                },
                supportingText = {
                    Text(text = "Дата добавления:\n27/03/2026")
                }
            )
        }
        item {
            EventCard(
                onClick = {},
                content = {
                    Image(
                        modifier = Modifier.fillMaxWidth(),
                        painter = painterResource(R.drawable.card_placeholder_2),
                        contentDescription = null
                    )
                },
                text = {
                    Text(text = "Хуекция")
                },
                supportingText = {
                    Text(text = "Дата добавления:\n28/03/2026")
                }
            )
        }
        item {
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
                    Text(text = "Лекция")
                },
                supportingText = {
                    Text(text = "Дата добавления:\n27/03/2026")
                }
            )
        }
        item {
            EventCard(
                onClick = {},
                content = {
                    Image(
                        modifier = Modifier.fillMaxWidth(),
                        painter = painterResource(R.drawable.card_placeholder_2),
                        contentDescription = null
                    )
                },
                text = {
                    Text(text = "Хуекция")
                },
                supportingText = {
                    Text(text = "Дата добавления:\n28/03/2026")
                }
            )
        }
    }
}

@Preview
@Composable
fun ActiveEventsScreenPreview() {
    ActiveEventsScreen()
}
