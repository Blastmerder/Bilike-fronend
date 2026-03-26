package com.eveningwithsolovyov.beelike.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eveningwithsolovyov.beelike.ui.theme.ColorSchemeDandelion
import com.eveningwithsolovyov.beelike.ui.theme.TypographyDandelion

@Composable
fun TextFieldDandelion(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: @Composable () -> Unit,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    OutlinedTextField(
        modifier = Modifier
            .then(modifier),
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            ProvideTextStyle(
                value = TypographyDandelion.textFieldPlaceholder,
                content = placeholder
            )
        },
        textStyle = TypographyDandelion.textFieldMain.copy(),
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = ColorSchemeDandelion.surface,
            focusedContainerColor = ColorSchemeDandelion.surface,
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent,
            unfocusedPlaceholderColor = ColorSchemeDandelion.onSurfaceVariant,
            focusedPlaceholderColor = ColorSchemeDandelion.onSurfaceVariant,
            unfocusedTextColor = ColorSchemeDandelion.onSurface,
            focusedTextColor = ColorSchemeDandelion.onSurface,
        ),
        shape = RoundedCornerShape(15.dp)
    )
}

@Preview
@Composable
fun TextFieldDandelionPreview() {
    TextFieldDandelion(
        value = "",
        onValueChange = {},
        placeholder = {
            Text(text = "Номер телефона")
        }
    )
}