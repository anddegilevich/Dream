package and.degilevich.dream.shared.design.system.button

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.foundation.compose.preview.BooleanPreviewProvider
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.animation.animateColorAsState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter

@Composable
fun PrimaryTextButton(
    text: String,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    onClicked: () -> Unit
) {
    val textColor by animateColorAsState(
        targetValue = if (isEnabled) {
            Theme.colors.button.primary.text
        } else {
            Theme.colors.button.primary.textDisabled
        }
    )

    PrimaryButton(
        modifier = modifier,
        isEnabled = isEnabled,
        onClicked = onClicked
    ) {
        Text(
            text = text,
            color = textColor
        )
    }
}

@LightDarkPreviews
@Composable
private fun PrimaryTextButtonPreview(
    @PreviewParameter(BooleanPreviewProvider::class)
    isEnabled: Boolean
) = ComposeAppTheme {
    PrimaryTextButton(
        text = "Button",
        isEnabled = isEnabled
    ) { }
}
