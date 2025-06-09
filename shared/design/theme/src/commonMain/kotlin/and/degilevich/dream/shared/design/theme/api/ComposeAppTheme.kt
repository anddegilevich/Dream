@file:Suppress("CompositionLocalAllowlist")

package and.degilevich.dream.shared.design.theme.api

import and.degilevich.dream.shared.design.theme.api.component.ThemeFonts
import and.degilevich.dream.shared.design.theme.api.component.ThemeTypography
import and.degilevich.dream.shared.design.theme.api.component.color.ThemeColors
import and.degilevich.dream.shared.design.theme.impl.component.ThemeFontsImpl
import and.degilevich.dream.shared.design.theme.impl.component.ThemeTypographyImpl
import and.degilevich.dream.shared.design.theme.impl.component.color.DarkThemeColors
import and.degilevich.dream.shared.design.theme.impl.component.color.LightThemeColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf

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
    val fonts: ThemeFonts = remember { ThemeFontsImpl() }
    val typography: ThemeTypography = remember(fonts) {
        ThemeTypographyImpl(
            fonts = fonts
        )
    }

    CompositionLocalProvider(
        LocalColors provides colors,
        LocalFonts provides fonts,
        LocalTypography provides typography,
    ) {
        content()
    }
}

internal val LocalColors: ProvidableCompositionLocal<ThemeColors> = compositionLocalOf { DarkThemeColors() }
internal val LocalFonts: ProvidableCompositionLocal<ThemeFonts> = staticCompositionLocalOf { ThemeFontsImpl() }
internal val LocalTypography: ProvidableCompositionLocal<ThemeTypography> = staticCompositionLocalOf {
    ThemeTypographyImpl(fonts = ThemeFontsImpl())
}