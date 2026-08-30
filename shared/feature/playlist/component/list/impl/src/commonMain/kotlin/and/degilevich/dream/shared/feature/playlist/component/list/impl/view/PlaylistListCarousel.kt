package and.degilevich.dream.shared.feature.playlist.component.list.impl.view

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.playlist.ui.api.view.LikedSongsCard
import and.degilevich.dream.shared.feature.playlist.ui.api.view.PlaylistCard
import and.degilevich.dream.shared.feature.playlist.ui.api.view.skeleton.SkeletonPlaylistCard
import and.degilevich.dream.shared.feature.playlist.component.list.impl.component.model.PlaylistListIntent
import and.degilevich.dream.shared.feature.playlist.component.list.impl.component.model.PlaylistListUIState
import and.degilevich.dream.shared.feature.playlist.component.list.impl.preview.PlaylistListUIStatePreviewProvider
import and.degilevich.dream.shared.feature.playlist.component.list.impl.view.semantic.PlaylistListCarouselSemantic
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.identifiedSkeletonItems
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun PlaylistListCarousel(
    state: PlaylistListUIState,
    modifier: Modifier = Modifier,
    onIntent: (PlaylistListIntent) -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            modifier = Modifier
                .testTag(PlaylistListCarouselSemantic.TEST_TAG_TITLE)
                .padding(horizontal = 16.dp),
            text = stringResource(Res.strings.title_my_playlists),
            color = Theme.colors.text.primary,
            style = Theme.typography.h1
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                horizontal = 16.dp,
                vertical = 8.dp
            ),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.Top
        ) {
            item {
                LikedSongsCard(
                    modifier = Modifier.testTag(PlaylistListCarouselSemantic.TEST_TAG_LIKED_SONGS)
                ) {
                    onIntent(PlaylistListIntent.OnLikedSongsClicked)
                }
            }
            identifiedSkeletonItems(
                skeleton = state.playlists,
                loadingItemsCount = LOADING_ITEMS_COUNT,
                loadingItemContent = {
                    SkeletonPlaylistCard(
                        modifier = Modifier.testTag(PlaylistListCarouselSemantic.TEST_TAG_ITEM_SKELETON)
                    )
                },
                itemContent = { playlist ->
                    PlaylistCard(
                        modifier = Modifier
                            .testTag(PlaylistListCarouselSemantic.TEST_TAG_ITEM)
                            .animateItem(),
                        data = playlist
                    ) { id ->
                        onIntent(
                            PlaylistListIntent.OnPlaylistClicked(id = id)
                        )
                    }
                }
            )
        }
    }
}

private const val LOADING_ITEMS_COUNT = 10

@LightDarkPreviews
@Composable
private fun PlaylistListCarouselPreview(
    @PreviewParameter(PlaylistListUIStatePreviewProvider::class)
    state: PlaylistListUIState
) {
    ComposeAppTheme {
        PlaylistListCarousel(
            modifier = Modifier.themeBackground(),
            state = state
        ) {}
    }
}
