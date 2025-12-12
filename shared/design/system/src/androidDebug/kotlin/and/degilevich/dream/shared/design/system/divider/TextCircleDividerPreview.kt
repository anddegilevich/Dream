package and.degilevich.dream.shared.design.system.divider

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.foundation.compose.preview.DayNightPreviews
import androidx.compose.runtime.Composable

@DayNightPreviews
@Composable
private fun TextCircleDividerPreview() {
    ComposeAppTheme {
        TextCircleDivider(
            color = Theme.colors.text.secondary
        )
    }
}