package and.degilevich.dream.shared.design.theme.impl.component.color.dark

import and.degilevich.dream.shared.design.theme.api.component.color.CommonThemeColors
import and.degilevich.dream.shared.design.theme.api.component.color.IconThemeColors
import and.degilevich.dream.shared.design.theme.api.component.color.TextThemeColors
import and.degilevich.dream.shared.design.theme.api.component.color.ThemeColors
import and.degilevich.dream.shared.design.theme.api.component.color.button.ButtonThemeColors
import and.degilevich.dream.shared.design.theme.api.component.color.field.FieldThemeColors
import and.degilevich.dream.shared.design.theme.impl.component.color.dark.button.DarkButtonThemeColors
import and.degilevich.dream.shared.design.theme.impl.component.color.dark.field.DarkFieldThemeColors
import androidx.compose.runtime.Immutable

@Immutable
internal class DarkThemeColors : ThemeColors {
    override val common: CommonThemeColors = DarkCommonThemeColors()
    override val text: TextThemeColors = DarkTextThemeColors()
    override val button: ButtonThemeColors = DarkButtonThemeColors()
    override val icon: IconThemeColors = DarkIconThemeColors()
    override val field: FieldThemeColors = DarkFieldThemeColors()
}