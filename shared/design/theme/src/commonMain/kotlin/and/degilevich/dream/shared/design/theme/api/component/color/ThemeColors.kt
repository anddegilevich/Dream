package and.degilevich.dream.shared.design.theme.api.component.color

import and.degilevich.dream.shared.design.theme.api.component.color.button.ButtonThemeColors
import and.degilevich.dream.shared.design.theme.api.component.color.field.FieldThemeColors
import androidx.compose.runtime.Immutable

@Immutable
interface ThemeColors {
    val common: CommonThemeColors
    val text: TextThemeColors

    val button: ButtonThemeColors
    val icon: IconThemeColors
    val field: FieldThemeColors
}