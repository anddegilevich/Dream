package and.degilevich.dream.shared.design.theme.impl.component.color

import and.degilevich.dream.shared.design.theme.api.component.color.ThemeIndifferentColors
import and.degilevich.dream.Res
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import dev.icerock.moko.resources.compose.colorResource

@Immutable
internal class ThemeIndifferentColorsImpl : ThemeIndifferentColors {
    override val brandGreen: Color
        @Composable
        get() = colorResource(Res.colors.malachite)
}