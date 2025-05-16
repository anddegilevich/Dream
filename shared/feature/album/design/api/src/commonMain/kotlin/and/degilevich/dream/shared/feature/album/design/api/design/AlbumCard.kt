package and.degilevich.dream.shared.feature.album.design.api.design

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.album.design.api.model.AlbumCardUIData
import and.degilevich.dream.shared.foundation.compose.ext.Space
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.clickableWithDebounce
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.scaleOnClick
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
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
    state: AlbumCardUIData,
    modifier: Modifier = Modifier,
    onCardClicked: (String) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = modifier
            .clickableWithDebounce(
                isEnabled = state.isEnabled,
                interactionSource = interactionSource,
                indication = ripple(color = Theme.colors.ripple)
            ) {
                onCardClicked(state.id)
            }
            .scaleOnClick(
                isEnabled = state.isEnabled,
                interactionSource = interactionSource
            )
            .border(
                width = 2.dp,
                color = Theme.colors.outline,
                shape = RoundedCornerShape(corner = CornerSize(8.dp)),
            )
            .themeBackground()
            .padding(16.dp)
            .width(152.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AlbumIcon(
            modifier = Modifier.size(152.dp),
            iconUrl = state.iconUrl
        )
        Space(height = 8.dp)
        Text(
            text = state.name,
            color = Theme.colors.textPrimary,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
        Space(height = 8.dp)
        Text(
            text = state.artists,
            color = Theme.colors.textLabel,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}