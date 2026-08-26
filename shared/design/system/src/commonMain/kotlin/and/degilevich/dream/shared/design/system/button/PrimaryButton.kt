package and.degilevich.dream.shared.design.system.button

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.foundation.compose.click.rememberDebounced
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.scaleOnClick
import and.degilevich.dream.shared.foundation.compose.preview.BooleanPreviewProvider
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp

@Composable
fun PrimaryButton(
    onClicked: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    content: @Composable () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val backgroundColor by animateColorAsState(
        targetValue = if (isEnabled) {
            Theme.colors.button.primary.background
        } else {
            Theme.colors.button.primary.backgroundDisabled
        }
    )
    val onClickedDebounced = rememberDebounced(block = onClicked)

    Box(
        modifier = modifier
            .scaleOnClick(
                isEnabled = isEnabled,
                interactionSource = interactionSource
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = isEnabled,
                onClick = onClickedDebounced
            )
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(size = 20.dp)
            )
            .padding(
                vertical = 12.dp,
                horizontal = 20.dp
            ),
        contentAlignment = Alignment.Center,
        content = { content() }
    )
}

@LightDarkPreviews
@Composable
private fun PrimaryButtonPreview(
    @PreviewParameter(BooleanPreviewProvider::class)
    isEnabled: Boolean
) = ComposeAppTheme {
    PrimaryButton(
        onClicked = { },
        isEnabled = isEnabled
    ) {
        Text(text = "Button")
    }
}
