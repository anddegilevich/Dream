package and.degilevich.dream.shared.design.theme.impl.component.color.light.button

import and.degilevich.dream.shared.design.theme.api.component.color.button.BorderlessButtonThemeColors
import and.degilevich.dream.shared.design.theme.api.component.color.button.ButtonThemeColors
import and.degilevich.dream.shared.design.theme.api.component.color.button.OutlinedButtonThemeColors
import and.degilevich.dream.shared.design.theme.api.component.color.button.PrimaryButtonThemeColors
import and.degilevich.dream.shared.design.theme.api.component.color.button.SecondaryButtonThemeColors

internal class LightButtonThemeColors : ButtonThemeColors {
    override val primary: PrimaryButtonThemeColors = LightPrimaryButtonThemeColors()
    override val secondary: SecondaryButtonThemeColors = LightSecondaryButtonThemeColors()
    override val outlined: OutlinedButtonThemeColors = LightOutlinedButtonThemeColors()
    override val borderless: BorderlessButtonThemeColors = LightBorderlessButtonThemeColors()
}