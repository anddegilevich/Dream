package and.degilevich.dream.shared.feature.playlist.component.details.impl.view

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.system.button.IconButton
import and.degilevich.dream.shared.design.system.modifier.roundedThemeShimmer
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.playlist.component.details.impl.component.model.PlaylistDetailsIntent
import and.degilevich.dream.shared.feature.playlist.component.details.impl.component.model.PlaylistDetailsUIState
import and.degilevich.dream.shared.feature.playlist.component.details.impl.preview.PlaylistDetailsUIStatePreviewProvider
import and.degilevich.dream.shared.feature.playlist.component.details.impl.view.semantic.PlaylistDetailsScreenSemantic
import and.degilevich.dream.shared.feature.playlist.component.details.impl.view.skeleton.SkeletonPlaylistDetailsHeader
import and.degilevich.dream.shared.feature.playlist.ui.api.view.PlaylistTrackCard
import and.degilevich.dream.shared.feature.playlist.ui.api.view.skeleton.SkeletonPlaylistTrackCard
import and.degilevich.dream.shared.foundation.compose.ext.plus
import and.degilevich.dream.shared.foundation.compose.list.OnLastItemDisplayedSideEffect
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.SkeletonCrossfade
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.identifiedSkeletonItems
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun PlaylistDetailsScreen(
    state: PlaylistDetailsUIState,
    modifier: Modifier = Modifier,
    onIntent: (PlaylistDetailsIntent) -> Unit
) {
    val listState = rememberLazyListState()

    if (state.tracks is Skeleton.Value) {
        OnLastItemDisplayedSideEffect(
            listState = listState,
            threshold = LOAD_NEXT_PAGE_THRESHOLD
        ) {
            onIntent(PlaylistDetailsIntent.OnNextPageRequested)
        }
    }

    LazyColumn(
        state = listState,
        modifier = modifier
            .themeBackground()
            .fillMaxSize(),
        contentPadding = PaddingValues(
            vertical = 12.dp,
            horizontal = 16.dp
        )
            .plus(WindowInsets.statusBars.asPaddingValues())
            .plus(WindowInsets.navigationBars.asPaddingValues()),
        verticalArrangement = Arrangement.spacedBy(space = 12.dp)
    ) {
        item {
            IconButton(
                modifier = Modifier
                    .testTag(PlaylistDetailsScreenSemantic.TEST_TAG_BACK)
                    .size(24.dp),
                painter = painterResource(Res.images.ic_back)
            ) {
                onIntent(PlaylistDetailsIntent.OnBackClicked)
            }
        }
        item {
            SkeletonCrossfade(
                skeleton = state.header,
                loadingContent = {
                    SkeletonPlaylistDetailsHeader(
                        modifier = Modifier
                            .testTag(PlaylistDetailsScreenSemantic.TEST_TAG_HEADER_SKELETON)
                            .fillMaxWidth()
                    )
                },
                content = { data ->
                    PlaylistDetailsHeader(
                        modifier = Modifier
                            .testTag(PlaylistDetailsScreenSemantic.TEST_TAG_HEADER)
                            .fillMaxWidth(),
                        data = data
                    )
                }
            )
        }
        item {
            SkeletonCrossfade(
                skeleton = state.count,
                loadingContent = {
                    Spacer(
                        modifier = Modifier
                            .testTag(PlaylistDetailsScreenSemantic.TEST_TAG_COUNT_SKELETON)
                            .roundedThemeShimmer()
                            .size(
                                width = 80.dp,
                                height = 12.dp
                            )
                    )
                },
                content = { count ->
                    Text(
                        modifier = Modifier.testTag(PlaylistDetailsScreenSemantic.TEST_TAG_COUNT),
                        text = count,
                        style = Theme.typography.label,
                        color = Theme.colors.text.secondary
                    )
                }
            )
        }
        identifiedSkeletonItems(
            skeleton = state.tracks,
            loadingItemsCount = LOADING_ITEMS_COUNT,
            loadingItemContent = {
                SkeletonPlaylistTrackCard(
                    modifier = Modifier
                        .testTag(PlaylistDetailsScreenSemantic.TEST_TAG_ITEM_SKELETON)
                        .fillMaxWidth()
                )
            },
            itemContent = { track ->
                PlaylistTrackCard(
                    modifier = Modifier
                        .testTag(PlaylistDetailsScreenSemantic.TEST_TAG_ITEM)
                        .animateItem()
                        .fillMaxWidth(),
                    data = track
                ) { trackId ->
                    onIntent(PlaylistDetailsIntent.OnTrackClicked(id = trackId))
                }
            }
        )
        if (state.isLoadingTracks) {
            items(count = LOADING_ITEMS_COUNT) {
                SkeletonPlaylistTrackCard(
                    modifier = Modifier
                        .testTag(PlaylistDetailsScreenSemantic.TEST_TAG_NEXT_PAGE_SKELETON)
                        .fillMaxWidth()
                )
            }
        }
    }
}

private const val LOADING_ITEMS_COUNT = 10
private const val LOAD_NEXT_PAGE_THRESHOLD = 10

@LightDarkPreviews
@Composable
private fun PlaylistDetailsScreenPreview(
    @PreviewParameter(PlaylistDetailsUIStatePreviewProvider::class)
    state: PlaylistDetailsUIState
) = ComposeAppTheme {
    PlaylistDetailsScreen(
        state = state
    ) { }
}
