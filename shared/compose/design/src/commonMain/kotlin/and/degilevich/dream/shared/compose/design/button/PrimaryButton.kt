package and.degilevich.dream.shared.compose.design.button

import and.degilevich.dream.shared.compose.theme.api.Theme
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.clickableWithDebounce
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.scaleOnClick
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
                color = Theme.colors.buttonPrimary,
                shape = RoundedCornerShape(corner = CornerSize(20.dp)) //FIXME: Move to Theme.shapes
            )
            .padding(
                vertical = 12.dp,
                horizontal = 20.dp
            ),
        text = text,
        color = Theme.colors.buttonPrimaryText
    )
}