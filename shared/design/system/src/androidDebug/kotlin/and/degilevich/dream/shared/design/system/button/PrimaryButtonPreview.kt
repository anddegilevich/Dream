package and.degilevich.dream.shared.design.system.button

import and.degilevich.dream.shared.design.theme.api.DreamTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun PrimaryButtonDarkPreview() {
    DreamTheme(
        isDarkMode = false
    ) {
        PrimaryButton(
            text = "Button"
        ) { }
    }
}

@Preview
@Composable
private fun PrimaryButtonLightPreview() {
    DreamTheme(
        isDarkMode = false
    ) {
        PrimaryButton(
            text = "Button"
        ) { }
    }
}