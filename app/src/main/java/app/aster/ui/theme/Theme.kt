package app.aster.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val AsterDarkScheme = darkColorScheme(
    primary = AsterVioletLight,
    onPrimary = Color(0xFF150A2E),
    primaryContainer = AsterVioletDark,
    onPrimaryContainer = Color(0xFFE7E0FF),
    secondary = AsterSage,
    onSecondary = Color(0xFF002019),
    tertiary = AsterNova,
    onTertiary = Color(0xFF2A0F05),
    background = AsterInk,
    onBackground = AsterCloud,
    surface = AsterSurface,
    onSurface = AsterCloud,
    surfaceVariant = Color(0xFF222836),
    onSurfaceVariant = AsterMuted,
    error = Color(0xFFFF6B6B),
    onError = Color(0xFF2A0000),
)

private val AsterLightScheme = lightColorScheme(
    primary = AsterViolet,
    onPrimary = AsterPaper,
    primaryContainer = Color(0xFFE7E0FF),
    onPrimaryContainer = Color(0xFF1E0066),
    secondary = AsterSage,
    onSecondary = AsterPaper,
    tertiary = AsterNova,
    onTertiary = AsterPaper,
    background = AsterCloud,
    onBackground = AsterInk,
    surface = AsterPaper,
    onSurface = AsterInk,
    error = Color(0xFFB00020),
    onError = AsterPaper,
)

@Composable
fun AsterTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    // Own brand scheme (not Material You dynamic color) so Aster always looks like Aster.
    // Accessibility: callers can force dark/light; system dark respected by default.
    val colorScheme = if (darkTheme) AsterDarkScheme else AsterLightScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = android.graphics.Color.TRANSPARENT
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }
    MaterialTheme(colorScheme = colorScheme, content = content)
}
