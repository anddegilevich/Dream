package and.degilevich.dream.shared.design.system.button

import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.clickableWithDebounce
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.scaleOnClick
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

@Composable
fun IconButton(
    painter: Painter,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    tint: Color = Theme.colors.common.icon,
    onClicked: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    Icon(
        modifier = modifier
            .scaleOnClick(
                isEnabled = isEnabled,
                interactionSource = interactionSource
            )
            .clip(CircleShape)
            .clickableWithDebounce(
                isEnabled = isEnabled,
                interactionSource = interactionSource,
                onClicked = onClicked
            ),
        painter = painter,
        tint = tint,
        contentDescription = null
    )
}