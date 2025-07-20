package and.degilevich.dream.shated.feature.track.design.api.design

import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.foundation.compose.ext.Space
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.clickableWithDebounce
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.scaleOnClick
import and.degilevich.dream.shated.feature.track.design.api.model.TrackCardUIData
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TrackCard(
    data: TrackCardUIData,
    modifier: Modifier = Modifier,
    onClicked: (String) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier
            .clickableWithDebounce(
                interactionSource = interactionSource,
            ) {
                onClicked(data.id)
            }
            .scaleOnClick(
                interactionSource = interactionSource
            )
    ) {
        Text(
            text = data.name,
            style = Theme.typography.main,
            color = Theme.colors.text.primary
        )
        Space(height = 4.dp)
        Text(
            text = data.artists,
            style = Theme.typography.label,
            color = Theme.colors.text.secondary
        )
    }
}