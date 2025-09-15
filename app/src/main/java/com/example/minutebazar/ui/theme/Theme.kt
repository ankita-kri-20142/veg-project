package com.example.minutebazar.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Typography

// Define your colors properly here with Color values
private val GreenPrimary = Color(0xFF4CAF50)   // example green
private val YellowAccent = Color(0xFFFFEB3B)   // example yellow
private val Background = Color(0xFFFFFFFF)     // white background
private val SurfaceWhite = Color(0xFFFFFFFF)   // white surface
private val TextBlack = Color(0xFF000000)      // black text

@Composable
fun MinuteBazarTheme(content: @Composable () -> Unit) {
    val colorScheme = lightColorScheme(
        primary = GreenPrimary,
        secondary = YellowAccent,
        background = Background,
        surface = SurfaceWhite,
        onPrimary = SurfaceWhite,
        onSecondary = TextBlack,
        onBackground = TextBlack,
        onSurface = TextBlack,
    )

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
