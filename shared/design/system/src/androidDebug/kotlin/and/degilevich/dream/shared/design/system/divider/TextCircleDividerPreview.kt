package and.degilevich.dream.shared.design.system.divider

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.runtime.Composable

@PreviewLightDark
@Composable
private fun TextCircleDividerPreview() {
    ComposeAppTheme {
        TextCircleDivider(
            color = Theme.colors.text.secondary
        )
    }
}