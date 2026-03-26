package com.eveningwithsolovyov.beelike.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontSynthesis
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eveningwithsolovyov.beelike.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

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
}
