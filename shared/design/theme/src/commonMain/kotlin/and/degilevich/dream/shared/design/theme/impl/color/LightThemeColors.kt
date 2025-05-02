package and.degilevich.dream.shared.design.theme.impl.color

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.theme.api.colors.ThemeColors
import and.degilevich.dream.shared.design.theme.api.colors.ThemeIndifferentColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import dev.icerock.moko.resources.compose.colorResource

internal class LightThemeColors : ThemeColors, ThemeIndifferentColors by ThemeIndifferentColorsImpl() {
    // Common
    override val background: Color
        @Composable
        get() = colorResource(Res.colors.white)
    override val ripple: Color
        @Composable
        get() = brandGreen
    override val icon: Color
        @Composable
        get() = black
    override val iconPlaceholderBackground: Color
        @Composable
        get() = colorResource(Res.colors.philippine_silver)
    override val outline: Color
        @Composable
        get() = black

    // Text
    override val textPrimary: Color
        @Composable
        get() = black
    override val textSecondary: Color
        @Composable
        get() = colorResource(Res.colors.philippine_silver)
    override val textLabel: Color
        @Composable
        get() = colorResource(Res.colors.spanish_gray)

    // Button
    override val buttonPrimary: Color
        @Composable
        get() = brandGreen
    override val buttonPrimaryDisabled: Color
        @Composable
        get() = colorResource(Res.colors.davys_gray)
    override val buttonPrimaryText: Color
        @Composable
        get() = white
    override val buttonPrimaryTextDisabled: Color
        @Composable
        get() = buttonPrimaryText

    override val buttonSecondary: Color
        @Composable
        get() = colorResource(Res.colors.cultured)
    override val buttonSecondaryDisabled: Color
        @Composable
        get() = colorResource(Res.colors.davys_gray)
    override val buttonSecondaryText: Color
        @Composable
        get() = colorResource(Res.colors.chinese_black)
    override val buttonSecondaryTextDisabled: Color
        @Composable
        get() = buttonSecondaryText

    override val buttonOutlined: Color
        @Composable
        get() = black
    override val buttonOutlinedDisabled: Color
        @Composable
        get() = colorResource(Res.colors.davys_gray)
    override val buttonOutlinedText: Color
        @Composable
        get() = black
    override val buttonOutlinedTextDisabled: Color
        @Composable
        get() = colorResource(Res.colors.davys_gray)

    override val buttonBorderlessText: Color
        @Composable
        get() = black
    override val buttonBorderlessTextDisabled: Color
        @Composable
        get() = colorResource(Res.colors.davys_gray)
}