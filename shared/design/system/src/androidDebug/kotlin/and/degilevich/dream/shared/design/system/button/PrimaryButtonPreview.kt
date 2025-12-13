package and.degilevich.dream.shared.design.system.button

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.runtime.Composable

@PreviewLightDark
@Composable
private fun PrimaryButtonPreview() {
    ComposeAppTheme {
        PrimaryButton(
            text = "Button"
        ) { }
    }
}