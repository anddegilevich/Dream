package and.degilevich.dream.shared.design.system.button

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun PrimaryButtonDarkPreview() {
    ComposeAppTheme(
        isDarkMode = true
    ) {
        PrimaryButton(
            text = "Button"
        ) { }
    }
}

@Preview
@Composable
private fun PrimaryButtonLightPreview() {
    ComposeAppTheme(
        isDarkMode = false
    ) {
        PrimaryButton(
            text = "Button"
        ) { }
    }
}