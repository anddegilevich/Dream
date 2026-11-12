package and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.view

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.system.button.IconButton
import and.degilevich.dream.shared.design.system.indication.themeRipple
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.ui.api.view.AlbumIcon
import and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.component.model.MiniPlayerIntent
import and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.component.model.MiniPlayerUIState
import and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.preview.MiniPlayerUIStatePreviewProvider
import and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.view.semantic.MiniPlayerViewSemantic
import and.degilevich.dream.shared.feature.player.ui.api.view.PlayIconButton
import and.degilevich.dream.shared.feature.player.ui.api.view.ShuffleIconButton
import and.degilevich.dream.shared.foundation.compose.click.rememberDebounced
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import and.degilevich.dream.shated.feature.track.ui.api.view.TrackCardInfoView
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun MiniPlayerView(
    state: MiniPlayerUIState,
    modifier: Modifier = Modifier,
    onIntent: (MiniPlayerIntent) -> Unit
) {
    val onViewClickedDebounced = rememberDebounced { onIntent(MiniPlayerIntent.OnViewClicked) }

    Row(
        modifier = modifier
            .testTag(MiniPlayerViewSemantic.TEST_TAG_CONTENT)
            .fillMaxWidth()
            .themeBackground()
            .clickable(
                interactionSource = null,
                indication = themeRipple(),
                onClick = onViewClickedDebounced
            )
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(space = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AlbumIcon(
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(4.dp)),
            iconUrl = state.coverUrl
        )
        TrackCardInfoView(
            modifier = Modifier.weight(1f),
            data = state.track
        )
        MiniPlayerControls(
            isShuffling = state.isShuffling,
            isPlaying = state.isPlaying,
            onIntent = onIntent
        )
    }
}

@Composable
private fun MiniPlayerControls(
    isShuffling: Boolean,
    isPlaying: Boolean,
    modifier: Modifier = Modifier,
    onIntent: (MiniPlayerIntent) -> Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(space = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ShuffleIconButton(
            modifier = Modifier
                .testTag(MiniPlayerViewSemantic.TEST_TAG_SHUFFLE)
                .size(24.dp),
            isShuffling = isShuffling,
            onClicked = { onIntent(MiniPlayerIntent.OnShuffleClicked) }
        )
        IconButton(
            modifier = Modifier
                .testTag(MiniPlayerViewSemantic.TEST_TAG_SKIP_TO_PREVIOUS)
                .size(24.dp),
            painter = painterResource(Res.images.ic_skip_previous),
            onClicked = { onIntent(MiniPlayerIntent.OnSkipToPreviousClicked) }
        )
        PlayIconButton(
            modifier = Modifier
                .testTag(MiniPlayerViewSemantic.TEST_TAG_PLAY)
                .size(24.dp),
            isPlaying = isPlaying,
            onClicked = { onIntent(MiniPlayerIntent.OnPlayClicked) }
        )
        IconButton(
            modifier = Modifier
                .testTag(MiniPlayerViewSemantic.TEST_TAG_SKIP_TO_NEXT)
                .size(24.dp),
            painter = painterResource(Res.images.ic_skip_next),
            onClicked = { onIntent(MiniPlayerIntent.OnSkipToNextClicked) }
        )
    }
}

@LightDarkPreviews
@Composable
private fun MiniPlayerViewPreview(
    @PreviewParameter(MiniPlayerUIStatePreviewProvider::class)
    state: MiniPlayerUIState
) = ComposeAppTheme {
    MiniPlayerView(
        modifier = Modifier.themeBackground(),
        state = state
    ) {}
}
