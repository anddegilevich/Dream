package and.degilevich.dream.shared.feature.player.component.player.impl.view

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.system.button.IconButton
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.album.ui.api.view.AlbumIcon
import and.degilevich.dream.shared.feature.player.component.player.impl.component.model.PlayerIntent
import and.degilevich.dream.shared.feature.player.component.player.impl.component.model.PlayerUIState
import and.degilevich.dream.shared.feature.player.component.player.impl.preview.PlayerUIStatePreviewProvider
import and.degilevich.dream.shared.feature.player.component.player.impl.view.semantic.PlayerScreenSemantic
import and.degilevich.dream.shared.feature.player.ui.api.view.PlaybackProgressView
import and.degilevich.dream.shared.feature.player.ui.api.view.ShuffleIconButton
import and.degilevich.dream.shared.foundation.compose.ext.Space
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun PlayerScreen(
    state: PlayerUIState,
    modifier: Modifier = Modifier,
    onIntent: (PlayerIntent) -> Unit
) {
    Column(
        modifier = modifier
            .themeBackground()
            .fillMaxSize()
            .padding(
                top = 12.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = 32.dp
            )
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        IconButton(
            modifier = Modifier
                .testTag(PlayerScreenSemantic.TEST_TAG_BACK)
                .size(24.dp),
            painter = painterResource(Res.images.ic_back),
            onClicked = { onIntent(PlayerIntent.OnBackClicked) }
        )
        Space(height = 20.dp)
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            AlbumIcon(
                modifier = Modifier
                    .testTag(PlayerScreenSemantic.TEST_TAG_COVER)
                    .aspectRatio(1f),
                iconUrl = state.coverUrl
            )
        }
        Space(height = 32.dp)
        Text(
            text = state.track.name,
            style = Theme.typography.h2,
            color = Theme.colors.text.primary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Space(height = 4.dp)
        Text(
            text = state.track.artists,
            style = Theme.typography.main,
            color = Theme.colors.text.secondary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Space(height = 24.dp)
        PlaybackProgressView(
            modifier = Modifier
                .testTag(PlayerScreenSemantic.TEST_TAG_PROGRESS)
                .fillMaxWidth(),
            data = state.progress
        )
        Space(height = 24.dp)
        PlayerControls(
            modifier = Modifier.fillMaxWidth(),
            isShuffling = state.isShuffling,
            onIntent = onIntent
        )
    }
}

@Composable
private fun PlayerControls(
    isShuffling: Boolean,
    modifier: Modifier = Modifier,
    onIntent: (PlayerIntent) -> Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ShuffleIconButton(
            modifier = Modifier
                .testTag(PlayerScreenSemantic.TEST_TAG_SHUFFLE)
                .size(32.dp),
            isShuffling = isShuffling,
            onClicked = { onIntent(PlayerIntent.OnShuffleClicked) }
        )
        IconButton(
            modifier = Modifier
                .testTag(PlayerScreenSemantic.TEST_TAG_SKIP_TO_PREVIOUS)
                .size(40.dp),
            painter = painterResource(Res.images.ic_skip_previous),
            onClicked = { onIntent(PlayerIntent.OnSkipToPreviousClicked) }
        )
        IconButton(
            modifier = Modifier
                .testTag(PlayerScreenSemantic.TEST_TAG_SKIP_TO_NEXT)
                .size(40.dp),
            painter = painterResource(Res.images.ic_skip_next),
            onClicked = { onIntent(PlayerIntent.OnSkipToNextClicked) }
        )
    }
}

@LightDarkPreviews
@Composable
private fun PlayerScreenPreview(
    @PreviewParameter(PlayerUIStatePreviewProvider::class)
    state: PlayerUIState
) = ComposeAppTheme {
    PlayerScreen(
        state = state
    ) {}
}
