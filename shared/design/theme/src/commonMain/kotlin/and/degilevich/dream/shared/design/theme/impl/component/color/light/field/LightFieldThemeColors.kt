package and.degilevich.dream.shared.design.theme.impl.component.color.light.field

import and.degilevich.dream.shared.design.theme.api.component.color.field.FieldThemeColors
import and.degilevich.dream.shared.design.theme.api.component.color.field.SearchFieldThemeColors

internal class LightFieldThemeColors : FieldThemeColors {
    override val search: SearchFieldThemeColors = LightSearchFieldThemeColors()
}