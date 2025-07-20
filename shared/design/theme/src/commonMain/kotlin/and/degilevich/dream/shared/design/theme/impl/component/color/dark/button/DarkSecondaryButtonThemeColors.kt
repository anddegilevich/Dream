package and.degilevich.dream.shared.design.theme.impl.component.color.dark.button

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.theme.api.component.color.button.SecondaryButtonThemeColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import dev.icerock.moko.resources.compose.colorResource

internal class DarkSecondaryButtonThemeColors : SecondaryButtonThemeColors {
    override val button: Color
        @Composable
        get() = colorResource(Res.colors.cultured)
    override val buttonDisabled: Color
        @Composable
        get() = colorResource(Res.colors.davys_gray)
    override val text: Color
        @Composable
        get() = colorResource(Res.colors.chinese_black)
    override val textDisabled: Color
        @Composable
        get() = text
}