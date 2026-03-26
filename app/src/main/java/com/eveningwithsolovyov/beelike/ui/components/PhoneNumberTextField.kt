package com.eveningwithsolovyov.beelike.ui.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun PhoneNumberTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: @Composable () -> Unit
) {
    TextFieldDandelion(
        modifier = Modifier
            .then(modifier),
        value = value,
        onValueChange = {
            if (it.length > 11)
                return@TextFieldDandelion

            onValueChange(it)
        },
        placeholder = placeholder,
        visualTransformation = PhoneNumberVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword
        )
    )
}

class PhoneNumberVisualTransformation: VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        var out = ""

        for (i in text.text.indices) {
            if (i == 0) out += "+"
            out += text.text[i]
            if (i == 0) out += " ("
            if (i == 3) out += ") "
            if (i == 6) out += "-"
            if (i == 8) out += "-"
        }
        return TransformedText(
            text = AnnotatedString(text = out),
            offsetMapping = phoneNumberOffsetTranslator
        )
    }

    private val phoneNumberOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int =
            when (offset) {
                0 -> 0
                in 1..3 -> offset + 3
                in 4..6 -> offset + 5
                in 7..8 -> offset + 6
                else -> offset + 7
            }

        override fun transformedToOriginal(offset: Int): Int =
            when (offset) {
                in 0..1 -> 0
                in 2..4 -> 1
                in 5..7 -> offset - 3
                in 8..9 -> 4
                in 10..12 -> offset - 5
                13 -> 7
                in 14..15 -> offset - 6
                16 -> 9
                else -> offset - 7
            }
    }
}
