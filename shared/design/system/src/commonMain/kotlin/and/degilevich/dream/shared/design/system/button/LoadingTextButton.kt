package and.degilevich.dream.shared.design.system.button

import and.degilevich.dream.shared.design.system.loading.LoadingIndicator
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.foundation.compose.preview.BooleanPreviewProvider
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp

@Composable
fun LoadingTextButton(
    text: String,
    isLoading: Boolean,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    onClicked: () -> Unit
) {
    val contentColor by animateColorAsState(
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
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AnimatedVisibility(
                visible = isLoading,
                enter = expandHorizontally { it },
                exit = shrinkHorizontally { it }
            ) {
                LoadingIndicator(
                    size = 12.dp,
                    color = contentColor
                )
            }
            Text(
                text = text,
                color = contentColor
            )
        }
    }
}

@LightDarkPreviews
@Composable
private fun LoadingTextButtonPreview(
    @PreviewParameter(BooleanPreviewProvider::class)
    isLoading: Boolean
) = ComposeAppTheme {
    LoadingTextButton(
        text = "Button",
        isLoading = isLoading
    ) { }
}