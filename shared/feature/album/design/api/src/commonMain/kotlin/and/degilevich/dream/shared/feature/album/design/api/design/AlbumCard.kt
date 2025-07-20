package and.degilevich.dream.shared.feature.album.design.api.design

import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.album.design.api.model.AlbumCardUIData
import and.degilevich.dream.shared.foundation.compose.ext.Space
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.clickableWithDebounce
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.scaleOnClick
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun AlbumCard(
    data: AlbumCardUIData,
    modifier: Modifier = Modifier,
    onCardClicked: (String) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = modifier
            .clickableWithDebounce(
                isEnabled = data.isEnabled,
                interactionSource = interactionSource,
            ) {
                onCardClicked(data.id)
            }
            .scaleOnClick(
                isEnabled = data.isEnabled,
                interactionSource = interactionSource
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AlbumIcon(
            modifier = Modifier.size(120.dp),
            iconUrl = data.iconUrl
        )
        Space(height = 8.dp)
        Text(
            text = data.name,
            color = Theme.colors.text.primary,
            style = Theme.typography.h3,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
        Space(height = 4.dp)
        Text(
            text = data.artists,
            color = Theme.colors.text.secondary,
            style = Theme.typography.main,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}