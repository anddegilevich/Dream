package and.degilevich.dream.shared.design.theme.impl.component.color.dark

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.theme.api.component.color.CommonThemeColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import dev.icerock.moko.resources.compose.colorResource

internal class DarkCommonThemeColors : CommonThemeColors {
    override val background: Color
        @Composable
        get() = colorResource(Res.colors.chinese_black)
    override val brand: Color
        @Composable
        get() = colorResource(Res.colors.malachite)
    override val ripple: Color
        @Composable
        get() = brand
    override val line: Color
        @Composable
        get() = colorResource(Res.colors.philippine_silver)
}