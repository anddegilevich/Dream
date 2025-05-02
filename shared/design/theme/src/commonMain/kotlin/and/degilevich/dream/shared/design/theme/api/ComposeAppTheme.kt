package and.degilevich.dream.shared.design.theme.api

import and.degilevich.dream.shared.design.theme.api.colors.ThemeColors
import and.degilevich.dream.shared.design.theme.impl.color.DarkThemeColors
import and.degilevich.dream.shared.design.theme.impl.color.LightThemeColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember

@Composable
fun ComposeAppTheme(
    isDarkMode: Boolean,
    content: @Composable () -> Unit
) {
    val colors: ThemeColors = remember(isDarkMode) {
        if (isDarkMode) {
            DarkThemeColors()
        } else {
            LightThemeColors()
        }
    }

    CompositionLocalProvider(
        LocalColors provides colors,
        content
    )
}

@Suppress("CompositionLocalAllowlist")
internal val LocalColors: ProvidableCompositionLocal<ThemeColors> = compositionLocalOf { DarkThemeColors() }