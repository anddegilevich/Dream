package and.degilevich.dream.shared.feature.album.design.api.design

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.album.design.api.model.AlbumCardUIData
import and.degilevich.dream.shared.foundation.compose.ext.Space
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.clickableWithDebounce
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.scaleOnClick
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.ripple
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
                indication = ripple(color = Theme.colors.ripple)
            ) {
                onCardClicked(data.id)
            }
            .scaleOnClick(
                isEnabled = data.isEnabled,
                interactionSource = interactionSource
            )
            .themeBackground()
            .width(152.dp)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AlbumIcon(
            modifier = Modifier.size(152.dp),
            iconUrl = data.iconUrl
        )
        Space(height = 8.dp)
        Text(
            text = data.name,
            color = Theme.colors.textPrimary,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
        Space(height = 8.dp)
        Text(
            text = data.artists,
            color = Theme.colors.textLabel,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}