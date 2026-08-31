package and.degilevich.dream.shared.feature.playlist.ui.api.view

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.foundation.compose.click.rememberDebounced
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.scaleOnClick
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun LikedSongsCard(
    modifier: Modifier = Modifier,
    onClicked: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val onClickedDebounced = rememberDebounced { onClicked() }

    Column(
        modifier = modifier
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClickedDebounced
            )
            .scaleOnClick(interactionSource = interactionSource)
            .width(140.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Box(
            modifier = Modifier
                .size(140.dp)
                .background(color = Theme.colors.common.brand),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.fillMaxSize(fraction = 0.5f),
                painter = painterResource(Res.images.ic_heart),
                contentDescription = null,
                tint = Theme.colors.icon.primary
            )
        }
        Text(
            text = stringResource(Res.strings.title_liked_songs),
            color = Theme.colors.text.primary,
            style = Theme.typography.h4,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}

@LightDarkPreviews
@Composable
private fun LikedSongsCardPreview() = ComposeAppTheme {
    LikedSongsCard(
        modifier = Modifier.themeBackground()
    ) {}
}
