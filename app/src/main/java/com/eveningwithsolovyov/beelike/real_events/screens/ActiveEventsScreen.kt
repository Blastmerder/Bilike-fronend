package com.eveningwithsolovyov.beelike.real_events.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.eveningwithsolovyov.beelike.R
import com.eveningwithsolovyov.beelike.network.RetrofitInstance
import com.eveningwithsolovyov.beelike.network.UserRepository
import com.eveningwithsolovyov.beelike.real_events.ui.components.EventCard
import com.eveningwithsolovyov.beelike.real_events.viewmodels.ActiveEventsViewModel
import com.eveningwithsolovyov.beelike.real_events.viewmodels.ActiveEventsViewModelFactory
import com.eveningwithsolovyov.beelike.ui.components.BottomButtonDandelion
import com.eveningwithsolovyov.beelike.ui.theme.ColorSchemeDandelion

@Composable
fun ActiveEventsScreen(
    modifier: Modifier = Modifier,
    onBottomButtonClick: () -> Unit,
    userId: Int = -1
) {
    val repository = UserRepository(RetrofitInstance.api)
    val viewModel: ActiveEventsViewModel = viewModel(
        factory = ActiveEventsViewModelFactory(repository, userId)
    )

    val state by viewModel.state.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier),
    ) {
        LazyVerticalGrid(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(top = 20.dp),
            columns = GridCells.Fixed(count = 2),
            contentPadding = PaddingValues(start = 20.dp, end = 20.dp, bottom = 20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(state.userEvents) { event ->
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
                        Text(text = event.name)
                    },
                    supportingText = {
                        Text(text = event.description)
                    }
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 17.dp, topEnd = 17.dp))
                .background(ColorSchemeDandelion.primaryBright)
                .padding(16.dp)
        ) {
            BottomButtonDandelion(
                modifier = Modifier.fillMaxWidth(),
                onClick = onBottomButtonClick
            ) {
                Text("Записаться на мероприятие")
            }
        }
    }
}

@Preview
@Composable
fun ActiveEventsScreenPreview() {
    ActiveEventsScreen(
        onBottomButtonClick = {}
    )
}
