package and.degilevich.dream.shared.feature.playlist.ui.api.view

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.playlist.ui.api.model.PlaylistCardUIData
import and.degilevich.dream.shared.feature.playlist.ui.api.preview.PlaylistCardUIDataPreviewProvider
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import and.degilevich.dream.shared.foundation.compose.click.rememberDebounced
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.scaleOnClick
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp

@Composable
fun PlaylistCard(
    data: PlaylistCardUIData,
    onClick: (id: Identifier) -> Unit,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val onClickDebounced = rememberDebounced { onClick(data.id) }

    Column(
        modifier = modifier
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClickDebounced
            )
            .scaleOnClick(interactionSource = interactionSource)
            .width(140.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        PlaylistIcon(
            modifier = Modifier.size(140.dp),
            iconUrl = data.iconUrl
        )
        Text(
            text = data.name,
            color = Theme.colors.text.primary,
            style = Theme.typography.h4,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}

@PreviewLightDark
@Composable
private fun PlaylistCardPreview(
    @PreviewParameter(PlaylistCardUIDataPreviewProvider::class)
    data: PlaylistCardUIData
) = ComposeAppTheme {
    PlaylistCard(
        modifier = Modifier.themeBackground(),
        data = data,
        onClick = {}
    )
}
