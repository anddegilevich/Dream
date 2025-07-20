package and.degilevich.dream.shared.design.theme.impl.component.color.dark.button

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.theme.api.component.color.button.BorderlessButtonThemeColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import dev.icerock.moko.resources.compose.colorResource

internal class DarkBorderlessButtonThemeColors : BorderlessButtonThemeColors {
    override val text: Color
        @Composable
        get() = colorResource(Res.colors.white)
    override val textDisabled: Color
        @Composable
        get() = colorResource(Res.colors.davys_gray)
}