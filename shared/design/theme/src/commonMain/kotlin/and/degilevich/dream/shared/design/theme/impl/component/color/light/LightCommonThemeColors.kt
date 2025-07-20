package and.degilevich.dream.shared.design.theme.impl.component.color.light

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.theme.api.component.color.CommonThemeColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import dev.icerock.moko.resources.compose.colorResource

internal class LightCommonThemeColors : CommonThemeColors {

    override val background: Color
        @Composable
        get() = colorResource(Res.colors.white)
    override val brandGreen: Color
        @Composable
        get() = colorResource(Res.colors.malachite)
    override val ripple: Color
        @Composable
        get() = brandGreen
    override val icon: Color
        @Composable
        get() = colorResource(Res.colors.black)
    override val iconPlaceholderBackground: Color
        @Composable
        get() = colorResource(Res.colors.philippine_silver)
    override val outline: Color
        @Composable
        get() = colorResource(Res.colors.black)
}