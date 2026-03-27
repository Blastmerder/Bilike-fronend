package com.eveningwithsolovyov.beelike.leaderboard.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.eveningwithsolovyov.beelike.leaderboard.viewmodels.LeaderboardViewModel
import com.eveningwithsolovyov.beelike.leaderboard.viewmodels.LeaderboardViewModelFactory
import com.eveningwithsolovyov.beelike.network.RetrofitInstance
import com.eveningwithsolovyov.beelike.network.UserRepository
import com.eveningwithsolovyov.beelike.ui.components.ListItemDandelion
import com.eveningwithsolovyov.beelike.ui.theme.ColorSchemeDandelion
import com.eveningwithsolovyov.beelike.ui.theme.TypographyDandelion

@Composable
fun LeaderboardScreen(
    modifier: Modifier = Modifier
) {
    val repository = UserRepository(RetrofitInstance.api)
    val viewModel: LeaderboardViewModel = viewModel(
        factory = LeaderboardViewModelFactory(repository)
    )

    val state by viewModel.state.collectAsStateWithLifecycle()

    if (!state.isLoading) {
        if (state.sortedUsers.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp)
                    .then(modifier),
                contentPadding = PaddingValues(start = 20.dp, end = 20.dp, bottom = 20.dp),
                verticalArrangement = Arrangement.spacedBy(19.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(state.sortedUsers) { user ->
                    ListItemDandelion(
                        modifier = Modifier.fillMaxWidth(),
                        leadingText = {
                            Text(text = "${user.rank}. ${user.username}")
                        },
                        trailingText = {
                            Text(text = user.points.toString())
                        }
                    )
                }
            }
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .then(modifier),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Список пуст",
                    style = TypographyDandelion.cardText
                )
            }
        }
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .then(modifier),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                color = ColorSchemeDandelion.primaryDark
            )
        }
    }
}

@Preview
@Composable
fun LeaderboardScreenPreview() {
    LeaderboardScreen()
}
