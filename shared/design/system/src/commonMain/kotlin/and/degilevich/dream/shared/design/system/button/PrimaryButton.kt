package and.degilevich.dream.shared.design.system.button

import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.clickableWithDebounce
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.scaleOnClick
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PrimaryButton(
    text: String,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    onClicked: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val backgroundColor by animateColorAsState(
        targetValue = if (isEnabled) {
            Theme.colors.button.primary.background
        } else {
            Theme.colors.button.primary.backgroundDisabled
        }
    )
    val textColor by animateColorAsState(
        targetValue = if (isEnabled) {
            Theme.colors.button.primary.text
        } else {
            Theme.colors.button.primary.textDisabled
        }
    )

    Text(
        modifier = modifier
            .scaleOnClick(
                isEnabled = isEnabled,
                interactionSource = interactionSource
            )
            .clickableWithDebounce(
                isEnabled = isEnabled,
                interactionSource = interactionSource,
                onClicked = onClicked
            )
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(size = 20.dp)
            )
            .padding(
                vertical = 12.dp,
                horizontal = 20.dp
            ),
        text = text,
        color = textColor
    )
}