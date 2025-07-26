package and.degilevich.dream.shared.design.theme.impl.component.color.light

import and.degilevich.dream.shared.design.theme.api.component.color.CommonThemeColors
import and.degilevich.dream.shared.design.theme.api.component.color.IconThemeColors
import and.degilevich.dream.shared.design.theme.api.component.color.TextThemeColors
import and.degilevich.dream.shared.design.theme.api.component.color.ThemeColors
import and.degilevich.dream.shared.design.theme.api.component.color.button.ButtonThemeColors
import and.degilevich.dream.shared.design.theme.impl.component.color.light.button.LightButtonThemeColors
import androidx.compose.runtime.Immutable

@Immutable
internal class LightThemeColors : ThemeColors {
    override val common: CommonThemeColors = LightCommonThemeColors()
    override val text: TextThemeColors = LightTextThemeColors()
    override val button: ButtonThemeColors = LightButtonThemeColors()
    override val icon: IconThemeColors = LightIconThemeColors()
}