package com.eveningwithsolovyov.beelike.login.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.eveningwithsolovyov.beelike.login.viewmodels.LoginViewModel
import com.eveningwithsolovyov.beelike.navigation.Navigator
import com.eveningwithsolovyov.beelike.navigation.Route
import com.eveningwithsolovyov.beelike.ui.components.ButtonDandelion
import com.eveningwithsolovyov.beelike.ui.components.TextButtonDandelion
import com.eveningwithsolovyov.beelike.ui.components.TextFieldDandelion
import com.eveningwithsolovyov.beelike.ui.theme.ColorSchemeDandelion
import com.eveningwithsolovyov.beelike.ui.theme.TypographyDandelion

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = viewModel(),
    navigator: Navigator? = null
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(ColorSchemeDandelion.background)
                .padding(innerPadding)
                .padding(19.dp)
                .then(modifier),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Добро пожаловать!",
                style = TypographyDandelion.headerLarge
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "ВОЙДИТЕ В АККАУНТ",
                style = TypographyDandelion.headerSmall
            )
            Spacer(modifier = Modifier.height(40.dp))
            TextFieldDandelion(
                modifier = Modifier.fillMaxWidth(),
                value = state.usernameText,
                onValueChange = {
                    viewModel.updateUsernameText(it)
                },
                placeholder = {
                    Text(text = "Имя пользователя")
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextFieldDandelion(
                modifier = Modifier.fillMaxWidth(),
                value = state.passwordText,
                onValueChange = {
                    viewModel.updatePasswordText(it)
                },
                placeholder = {
                    Text(text = "Пароль")
                },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                )
            )
            Spacer(modifier = Modifier.height(30.dp))
            ButtonDandelion(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navigator?.navigate(Route.AppNavigation)
                }
            ) {
                Text(text = "ВОЙТИ")
            }
            Spacer(modifier = Modifier.weight(1f))
            TextButtonDandelion(
                onClick = {
                    navigator?.navigate(Route.Registration)
                }
            ) {
                Text(text = "НЕТ АККАНУТА? ЗАРЕГИСТРИРУЙТЕСЬ!")
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}
