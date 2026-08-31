package and.degilevich.dream.shared.design.system.button

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.foundation.compose.click.rememberDebounced
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.scaleOnClick
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun IconButton(
    painter: Painter,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    tint: Color = Theme.colors.icon.primary,
    onClicked: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val onClickedDebounced = rememberDebounced(block = onClicked)

    Icon(
        modifier = modifier
            .scaleOnClick(
                isEnabled = isEnabled,
                interactionSource = interactionSource
            )
            .clip(CircleShape)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = isEnabled,
                onClick = onClickedDebounced
            ),
        painter = painter,
        tint = tint,
        contentDescription = null
    )
}

@LightDarkPreviews
@Composable
private fun IconButtonPreview() = ComposeAppTheme {
    IconButton(
        modifier = Modifier.size(24.dp),
        painter = painterResource(Res.images.ic_back)
    ) { }
}