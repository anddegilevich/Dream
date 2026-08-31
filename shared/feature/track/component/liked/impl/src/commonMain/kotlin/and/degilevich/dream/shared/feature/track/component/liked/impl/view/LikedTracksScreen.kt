package and.degilevich.dream.shared.feature.track.component.liked.impl.view

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.system.button.IconButton
import and.degilevich.dream.shared.design.system.modifier.roundedThemeShimmer
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.track.component.liked.impl.component.model.LikedTracksIntent
import and.degilevich.dream.shared.feature.track.component.liked.impl.component.model.LikedTracksUIState
import and.degilevich.dream.shared.feature.track.component.liked.impl.preview.LikedTracksUIStatePreviewProvider
import and.degilevich.dream.shared.feature.track.component.liked.impl.view.semantic.LikedTracksScreenSemantic
import and.degilevich.dream.shared.foundation.compose.ext.plus
import and.degilevich.dream.shared.foundation.compose.list.OnLastItemDisplayedSideEffect
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.SkeletonCrossfade
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.identifiedSkeletonItems
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import and.degilevich.dream.shated.feature.track.ui.api.view.TrackCard
import and.degilevich.dream.shated.feature.track.ui.api.view.skeleton.SkeletonTrackCard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun LikedTracksScreen(
    state: LikedTracksUIState,
    modifier: Modifier = Modifier,
    onIntent: (LikedTracksIntent) -> Unit
) {
    val listState = rememberLazyListState()

    if (state.tracks is Skeleton.Value) {
        OnLastItemDisplayedSideEffect(
            listState = listState,
            threshold = LOAD_NEXT_PAGE_THRESHOLD
        ) {
            onIntent(LikedTracksIntent.OnNextPageRequested)
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
                    .testTag(LikedTracksScreenSemantic.TEST_TAG_BACK)
                    .size(24.dp),
                painter = painterResource(Res.images.ic_back)
            ) {
                onIntent(LikedTracksIntent.OnBackClicked)
            }
        }
        item {
            LikedTracksHeader(state = state)
        }
        identifiedSkeletonItems(
            skeleton = state.tracks,
            loadingItemsCount = LOADING_ITEMS_COUNT,
            loadingItemContent = {
                SkeletonTrackCard(
                    modifier = Modifier
                        .testTag(LikedTracksScreenSemantic.TEST_TAG_ITEM_SKELETON)
                        .fillMaxWidth()
                )
            },
            itemContent = { track ->
                TrackCard(
                    modifier = Modifier
                        .testTag(LikedTracksScreenSemantic.TEST_TAG_ITEM)
                        .animateItem()
                        .fillMaxWidth(),
                    data = track
                ) { trackId ->
                    onIntent(LikedTracksIntent.OnTrackClicked(id = trackId))
                }
            }
        )
        if (state.isLoadingTracks) {
            items(count = LOADING_ITEMS_COUNT) {
                SkeletonTrackCard(
                    modifier = Modifier
                        .testTag(LikedTracksScreenSemantic.TEST_TAG_NEXT_PAGE_SKELETON)
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Composable
private fun LikedTracksHeader(
    state: LikedTracksUIState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            modifier = Modifier.testTag(LikedTracksScreenSemantic.TEST_TAG_TITLE),
            text = stringResource(Res.strings.title_liked_songs),
            style = Theme.typography.h3,
            color = Theme.colors.text.primary
        )
        SkeletonCrossfade(
            skeleton = state.count,
            loadingContent = {
                Spacer(
                    modifier = Modifier
                        .testTag(LikedTracksScreenSemantic.TEST_TAG_COUNT_SKELETON)
                        .roundedThemeShimmer()
                        .size(
                            width = 80.dp,
                            height = 12.dp
                        )
                )
            },
            content = { count ->
                Text(
                    modifier = Modifier.testTag(LikedTracksScreenSemantic.TEST_TAG_COUNT),
                    text = count,
                    style = Theme.typography.label,
                    color = Theme.colors.text.secondary
                )
            }
        )
    }
}

private const val LOADING_ITEMS_COUNT = 10
private const val LOAD_NEXT_PAGE_THRESHOLD = 10

@LightDarkPreviews
@Composable
private fun LikedTracksScreenPreview(
    @PreviewParameter(LikedTracksUIStatePreviewProvider::class)
    state: LikedTracksUIState
) = ComposeAppTheme {
    LikedTracksScreen(
        state = state
    ) { }
}
