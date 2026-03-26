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
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.eveningwithsolovyov.beelike.api.UserRepository
import com.eveningwithsolovyov.beelike.api.RetrofitInstance
import com.eveningwithsolovyov.beelike.login.viewmodels.RegistrationViewModel
import com.eveningwithsolovyov.beelike.login.viewmodels.RegistrationViewModelFactory
import com.eveningwithsolovyov.beelike.navigation.Navigator
import com.eveningwithsolovyov.beelike.ui.components.ButtonDandelion
import com.eveningwithsolovyov.beelike.ui.components.CheckboxDandelion
import com.eveningwithsolovyov.beelike.ui.components.PhoneNumberTextField
import com.eveningwithsolovyov.beelike.ui.components.TextButtonDandelion
import com.eveningwithsolovyov.beelike.ui.components.TextFieldDandelion
import com.eveningwithsolovyov.beelike.ui.theme.ColorSchemeDandelion
import com.eveningwithsolovyov.beelike.ui.theme.TypographyDandelion

@Composable
fun RegistrationScreen(
    modifier: Modifier = Modifier,
    navigator: Navigator? = null
) {
    val repository = UserRepository(RetrofitInstance.api)
    val viewModel: RegistrationViewModel = viewModel(
        factory = RegistrationViewModelFactory(repository)
    )

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
                text = "Создайте свой аккаунт!",
                style = TypographyDandelion.headerLarge
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "СОЗДАЙТЕ АККАУНТ",
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
            PhoneNumberTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.phoneNumberText,
                onValueChange = {
                    viewModel.updatePhoneNumberText(it)
                },
                placeholder = {
                    Text(text = "Номер телефона")
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
            CheckboxDandelion(
                modifier = Modifier.fillMaxWidth(),
                checked = state.agreementChecked,
                onCheckedChange = {
                    viewModel.updateAgreementChecked(it)
                },
                headlineContent = {
                    Text(
                        text = "Я ознакомлен с политикой\nконфиденциальности",
                        lineHeight = 15.1f.sp
                    )
                }
            )
            Spacer(modifier = Modifier.height(30.dp))
            ButtonDandelion(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    viewModel.registerNewUser()
                }
            ) {
                Text(text = "СОЗДАТЬ АККАУНТ")
            }
            Spacer(modifier = Modifier.weight(1f))
            TextButtonDandelion(
                onClick = {
                    navigator?.goBack()
                }
            ) {
                Text(text = "ЕСТЬ АККАУНТ? ВОЙДИТЕ!")
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Preview
@Composable
fun RegistrationScreenPreview() {
    RegistrationScreen()
}
