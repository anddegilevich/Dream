package and.degilevich.dream.shared.design.theme.impl.component.color.dark

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.theme.api.component.color.ShimmerThemeColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import dev.icerock.moko.resources.compose.colorResource

internal class DarkShimmerThemeColors : ShimmerThemeColors {
    override val flash: Color
        @Composable
        get() = colorResource(Res.colors.charleston_grey)
    override val background: Color
        @Composable
        get() = colorResource(Res.colors.davys_gray)
}