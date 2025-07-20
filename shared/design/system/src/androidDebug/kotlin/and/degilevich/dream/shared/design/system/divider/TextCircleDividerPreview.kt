package and.degilevich.dream.shared.design.system.divider

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun TextCircleDividerDarkPreview() {
    ComposeAppTheme(
        isDarkMode = true
    ) {
        TextCircleDivider(
            color = Theme.colors.text.secondary
        )
    }
}

@Preview
@Composable
private fun TextCircleDividerLightPreview() {
    ComposeAppTheme(
        isDarkMode = false
    ) {
        TextCircleDivider(
            color = Theme.colors.text.secondary
        )
    }
}