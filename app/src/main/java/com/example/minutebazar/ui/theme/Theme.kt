package com.example.minutebazar.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = PrimaryGreen,
    onPrimary = White,
    secondary = SplashYellow,
    onSecondary = BlackText,
    background = PrimaryGreen,
    onBackground = White,
    surface = PrimaryGreen,
    onSurface = White
)

@Composable
fun MinuteBazarTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}
