package com.ashan.cartnova.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = CoralPink,
    secondary = SoftBlue,
    background = PureWhite,
    surface = PureWhite,
    onPrimary = PureWhite,
    onSecondary = TextDark
)

@Composable
fun CartNovaTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColors,
        content = content
    )
}