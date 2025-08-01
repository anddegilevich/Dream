package and.degilevich.dream.shared.feature.album.design.api.design

import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.album.design.api.model.AlbumCardUIData
import and.degilevich.dream.shared.foundation.compose.ext.Space
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.clickableWithDebounce
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.scaleOnClick
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
    onClicked: (id: String) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = modifier
            .clickableWithDebounce(
                interactionSource = interactionSource,
            ) {
                onClicked(data.id)
            }
            .scaleOnClick(
                interactionSource = interactionSource
            )
            .width(140.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AlbumIcon(
            modifier = Modifier.size(140.dp),
            iconUrl = data.iconUrl
        )
        Space(height = 4.dp)
        Text(
            text = data.name,
            color = Theme.colors.text.primary,
            style = Theme.typography.h4,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
        Text(
            text = data.artists,
            color = Theme.colors.text.secondary,
            style = Theme.typography.label,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}