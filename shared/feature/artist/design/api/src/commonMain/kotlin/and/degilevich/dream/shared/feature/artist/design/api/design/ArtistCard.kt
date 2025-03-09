package and.degilevich.dream.shared.feature.artist.design.api.design

import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.artist.design.api.model.ArtistCardUIState
import and.degilevich.dream.shared.foundation.compose.ext.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
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
fun ArtistCard(
    state: ArtistCardUIState,
    modifier: Modifier = Modifier,
    onCardClicked: (String) -> Unit
) {
    Column(
        modifier = modifier
            .clickable(
                enabled = state.isEnabled,
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(color = Theme.colors.ripple)
            ) {
                onCardClicked(state.id)
            }
            .border(
                width = 2.dp,
                color = Theme.colors.outline,
                shape = RoundedCornerShape(corner = CornerSize(8.dp)),
            )
            .background(
                color = Theme.colors.background
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArtistIcon(
            modifier = Modifier.size(80.dp),
            iconUrl = state.iconUrl
        )
        Space(height = 8.dp)
        Text(
            modifier = Modifier.widthIn(max = 100.dp),
            text = state.name,
            color = Theme.colors.textPrimary,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}