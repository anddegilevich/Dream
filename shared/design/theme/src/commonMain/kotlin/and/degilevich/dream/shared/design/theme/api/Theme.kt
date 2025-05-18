package and.degilevich.dream.shared.design.theme.api

import and.degilevich.dream.shared.design.theme.api.component.ThemeFonts
import and.degilevich.dream.shared.design.theme.api.component.ThemeTypography
import and.degilevich.dream.shared.design.theme.api.component.color.ThemeColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

object Theme {
    val colors: ThemeColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val fonts: ThemeFonts
        @Composable
        @ReadOnlyComposable
        get() = LocalFonts.current

    val typography: ThemeTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}