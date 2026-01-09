package and.degilevich.dream.shared.feature.category.component.list.api.design

import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.album.design.api.design.AlbumIcon
import and.degilevich.dream.shared.feature.category.component.list.api.component.model.CategoryCardUIData
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.clickableWithDebounce
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.scaleOnClick
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp

@Composable
fun CategoryCard(
    data: CategoryCardUIData,
    modifier: Modifier = Modifier,
    onClicked: (id: Identifier) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = modifier
            .scaleOnClick(interactionSource = interactionSource)
            .clickableWithDebounce(interactionSource = interactionSource) {
                onClicked(data.id)
            }
            .size(
                height = 108.dp,
                width = 192.dp
            )
            .clip(RoundedCornerShape(4.dp))
            .background(data.cardColor)
    ) {
        AlbumIcon(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(
                    x = 12.dp,
                    y = 8.dp
                )
                .rotate(ALBUM_ROTATION)
                .size(68.dp),
            iconUrl = data.albumCoverUrl
        )
        Text(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp),
            text = data.name,
            style = Theme.typography.h4,
            color = Theme.colors.text.primary
        )
    }
}

private const val ALBUM_ROTATION = 12f