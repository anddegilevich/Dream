package and.degilevich.dream.shared.design.theme.impl.component.color.light

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.theme.api.component.color.TextThemeColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import dev.icerock.moko.resources.compose.colorResource

internal class LightTextThemeColors : TextThemeColors {
    override val primary: Color
        @Composable
        get() = colorResource(Res.colors.black)
    override val secondary: Color
        @Composable
        get() = colorResource(Res.colors.philippine_silver)
    override val label: Color
        @Composable
        get() = colorResource(Res.colors.spanish_gray)
}