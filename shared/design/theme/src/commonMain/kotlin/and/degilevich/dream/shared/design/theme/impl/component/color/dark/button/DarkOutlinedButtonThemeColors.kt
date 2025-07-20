package and.degilevich.dream.shared.design.theme.impl.component.color.dark.button

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.theme.api.component.color.button.OutlinedButtonThemeColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import dev.icerock.moko.resources.compose.colorResource

internal class DarkOutlinedButtonThemeColors : OutlinedButtonThemeColors {
    override val outline: Color
        @Composable
        get() = colorResource(Res.colors.white)
    override val outlineDisabled: Color
        @Composable
        get() = colorResource(Res.colors.davys_gray)
    override val text: Color
        @Composable
        get() = colorResource(Res.colors.white)
    override val textDisabled: Color
        @Composable
        get() = colorResource(Res.colors.davys_gray)
}