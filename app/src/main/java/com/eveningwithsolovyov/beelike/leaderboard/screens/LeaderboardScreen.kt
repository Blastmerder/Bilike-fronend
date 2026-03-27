package com.eveningwithsolovyov.beelike.leaderboard.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.eveningwithsolovyov.beelike.ui.components.ListItemDandelion

@Composable
fun LeaderboardScreen(
    modifier: Modifier = Modifier
) {
    val viewModel: LeaderboardViewModel = viewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier),
        contentPadding = PaddingValues(top = 19.dp, start = 19.dp, end = 19.dp),
        verticalArrangement = Arrangement.spacedBy(19.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(state.sortedUsers) { user ->
            ListItemDandelion(
                modifier = Modifier.fillMaxWidth(),
                leadingText = {
                    Text(text = user.username)
                },
                trailingText = {
                    Text(text = user.points.toString())
                }
            )
        }
    }
}

@Preview
@Composable
fun LeaderboardScreenPreview() {
    LeaderboardScreen()
}
