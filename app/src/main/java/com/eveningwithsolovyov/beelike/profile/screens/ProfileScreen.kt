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
import com.eveningwithsolovyov.beelike.profile.viewmodels.ProfileViewModel
import com.eveningwithsolovyov.beelike.ui.components.PhoneNumberTextField
import com.eveningwithsolovyov.beelike.ui.components.TextFieldDandelion

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    val viewModel: ProfileViewModel = viewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(19.dp)
            .then(modifier)
    ) {
        TextFieldDandelion(
            modifier = Modifier.fillMaxWidth(),
            value = state.usernameText,
            onValueChange = {
                viewModel.updateUsernameText(it)
            },
            placeholder = {
                Text("Имя пользователя")
            }
        )
        Spacer(modifier = Modifier.height(19.dp))
        TextFieldDandelion(
            modifier = Modifier.fillMaxWidth(),
            value = state.fullNameText,
            onValueChange = {
                viewModel.updateFullNameText(it)
            },
            placeholder = {
                Text("Полное имя")
            }
        )
        Spacer(modifier = Modifier.height(19.dp))
        PhoneNumberTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.phoneNumberText,
            onValueChange = {
                viewModel.updatePhoneNumberText(it)
            },
            placeholder = {
                Text("Номер телефона")
            }
        )
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}
