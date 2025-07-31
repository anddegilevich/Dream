package and.degilevich.dream.shared.design.theme.impl.component.color.dark.field

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.theme.api.component.color.field.SearchFieldThemeColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import dev.icerock.moko.resources.compose.colorResource

internal class DarkSearchFieldThemeColors : SearchFieldThemeColors {
    override val text: Color
        @Composable
        get() = colorResource(Res.colors.white)
    override val placeholder: Color
        @Composable
        get() = colorResource(Res.colors.philippine_silver)
    override val cursor: Color
        @Composable
        get() = colorResource(Res.colors.malachite)
    override val icon: Color
        @Composable
        get() = colorResource(Res.colors.white)
    override val background: Color
        @Composable
        get() = colorResource(Res.colors.charleston_grey)
}