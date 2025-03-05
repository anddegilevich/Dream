package and.degilevich.dream.shared.design.theme.impl.color

import and.degilevich.dream.shared.design.theme.api.colors.DreamThemeIndifferentColors
import and.degilevich.dream.Res
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import dev.icerock.moko.resources.compose.colorResource

@Immutable
internal class DreamThemeIndifferentColorsImpl : DreamThemeIndifferentColors {
    override val brandGreen: Color
        @Composable
        get() = colorResource(Res.colors.malachite)
    override val white: Color
        @Composable
        get() = colorResource(Res.colors.white)
    override val black: Color
        @Composable
        get() = colorResource(Res.colors.black)
}