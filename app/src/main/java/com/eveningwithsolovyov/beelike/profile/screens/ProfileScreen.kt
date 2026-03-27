package com.eveningwithsolovyov.beelike.profile.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.eveningwithsolovyov.beelike.network.RetrofitInstance
import com.eveningwithsolovyov.beelike.network.UserRepository
import com.eveningwithsolovyov.beelike.profile.viewmodels.ProfileViewModel
import com.eveningwithsolovyov.beelike.profile.viewmodels.ProfileViewModelFactory
import com.eveningwithsolovyov.beelike.ui.components.ListItemDandelion
import kotlin.Int

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    userId: Int = -1
) {
    val repository = UserRepository(RetrofitInstance.api)
    val viewModel: ProfileViewModel = viewModel(
        factory = ProfileViewModelFactory(repository, userId)
    )

    val state by viewModel.state.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(19.dp)
            .then(modifier)
    ) {
        ListItemDandelion(
            modifier = Modifier.fillMaxWidth(),
            leadingText = {
                Text("Имя пользователя:")
            },
            trailingText = {
                Text(text = state.userData.username)
            }
        )
        Spacer(modifier = Modifier.height(19.dp))
        ListItemDandelion(
            modifier = Modifier.fillMaxWidth(),
            leadingText = {
                Text("Номер телефона:")
            },
            trailingText = {
                Text(text = state.userData.phoneNumber)
            }
        )
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}
