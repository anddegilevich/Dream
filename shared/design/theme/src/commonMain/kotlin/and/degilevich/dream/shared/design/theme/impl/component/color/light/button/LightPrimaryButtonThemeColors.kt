package and.degilevich.dream.shared.design.theme.impl.component.color.light.button

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.theme.api.component.color.button.PrimaryButtonThemeColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import dev.icerock.moko.resources.compose.colorResource

internal class LightPrimaryButtonThemeColors : PrimaryButtonThemeColors {
    override val background: Color
        @Composable
        get() = colorResource(Res.colors.malachite)
    override val backgroundDisabled: Color
        @Composable
        get() = colorResource(Res.colors.davys_gray)
    override val text: Color
        @Composable
        get() = colorResource(Res.colors.white)
    override val textDisabled: Color
        @Composable
        get() = text
}