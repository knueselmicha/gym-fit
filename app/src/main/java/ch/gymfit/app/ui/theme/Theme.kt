package ch.gymfit.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = accent,
    onPrimary = textPrimary,
    surface = card,
    surfaceVariant = cardElev,
    onSurface = textPrimary,
    background = bgMain,
    onBackground = textPrimary,
    error = danger
)

@Composable
fun GymFitTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography(),
        content = content
    )
}
