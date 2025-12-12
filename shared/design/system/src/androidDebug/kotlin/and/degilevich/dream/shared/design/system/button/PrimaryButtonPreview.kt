package and.degilevich.dream.shared.design.system.button

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.foundation.compose.preview.DayNightPreviews
import androidx.compose.runtime.Composable

@DayNightPreviews
@Composable
private fun PrimaryButtonPreview() {
    ComposeAppTheme {
        PrimaryButton(
            text = "Button"
        ) { }
    }
}