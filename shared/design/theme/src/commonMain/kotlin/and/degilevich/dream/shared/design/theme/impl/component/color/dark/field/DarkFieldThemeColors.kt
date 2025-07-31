package and.degilevich.dream.shared.design.theme.impl.component.color.dark.field

import and.degilevich.dream.shared.design.theme.api.component.color.field.FieldThemeColors
import and.degilevich.dream.shared.design.theme.api.component.color.field.SearchFieldThemeColors

internal class DarkFieldThemeColors : FieldThemeColors {
    override val search: SearchFieldThemeColors = DarkSearchFieldThemeColors()
}