package com.eveningwithsolovyov.beelike.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

object TypographyDandelion {
    val headerLarge = TextStyle(
        color = ColorSchemeDandelion.onBackground,
        fontSize = 28.sp,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.W800
    )
    val headerMedium = TextStyle(
        color = ColorSchemeDandelion.onBackgroundDark,
        fontSize = 28.sp,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.W500,
        letterSpacing = 0.1f.sp
    )
    val headerSmall = TextStyle(
        color = ColorSchemeDandelion.onBackgroundBright,
        fontSize = 14.sp,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.W400,
        letterSpacing = 0.7f.sp
    )
    val textFieldMain = TextStyle(
        color = ColorSchemeDandelion.onSurface,
        fontSize = 16.sp,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.W400,
        letterSpacing = 0.8f.sp
    )
    val textFieldPlaceholder = TextStyle(
        color = ColorSchemeDandelion.onSurfaceVariant,
        fontSize = 16.sp,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.W400,
        letterSpacing = 0.8f.sp
    )
    val buttonText = TextStyle(
        color = ColorSchemeDandelion.onPrimary,
        fontSize = 14.sp,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.W700,
        letterSpacing = 0.7f.sp
    )
    val cardText = TextStyle(
        color = ColorSchemeDandelion.onPrimary,
        fontSize = 16.sp,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.W400,
        lineHeight = 24.sp,
        letterSpacing = 0.5f.sp
    )
    val cardSupportingText = TextStyle(
        color = ColorSchemeDandelion.onPrimary,
        fontSize = 14.sp,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.W400,
        lineHeight = 20.sp,
        letterSpacing = 0.25f.sp
    )
    val errorText = TextStyle(
        color = ColorSchemeDandelion.error,
        fontSize = 14.sp,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.W400,
        textAlign = TextAlign.Center,
        letterSpacing = 0.7f.sp
    )
}
