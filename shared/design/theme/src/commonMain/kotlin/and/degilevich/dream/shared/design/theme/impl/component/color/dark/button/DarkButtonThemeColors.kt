package and.degilevich.dream.shared.design.theme.impl.component.color.dark.button

import and.degilevich.dream.shared.design.theme.api.component.color.button.BorderlessButtonThemeColors
import and.degilevich.dream.shared.design.theme.api.component.color.button.ButtonThemeColors
import and.degilevich.dream.shared.design.theme.api.component.color.button.OutlinedButtonThemeColors
import and.degilevich.dream.shared.design.theme.api.component.color.button.PrimaryButtonThemeColors
import and.degilevich.dream.shared.design.theme.api.component.color.button.SecondaryButtonThemeColors

internal class DarkButtonThemeColors : ButtonThemeColors {
    override val primary: PrimaryButtonThemeColors = DarkPrimaryButtonThemeColors()
    override val secondary: SecondaryButtonThemeColors = DarkSecondaryButtonThemeColors()
    override val outlined: OutlinedButtonThemeColors = DarkOutlinedButtonThemeColors()
    override val borderless: BorderlessButtonThemeColors = DarkBorderlessButtonThemeColors()
}