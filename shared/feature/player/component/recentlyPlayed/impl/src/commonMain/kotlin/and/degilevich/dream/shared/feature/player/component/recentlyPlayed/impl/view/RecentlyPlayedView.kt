package and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.view

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.component.model.RecentlyPlayedIntent
import and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.component.model.RecentlyPlayedUIState
import and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.preview.RecentlyPlayedUIStatePreviewProvider
import and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.view.semantic.RecentlyPlayedViewSemantic
import and.degilevich.dream.shared.feature.playlist.ui.api.view.PlaylistTrackCard
import and.degilevich.dream.shared.feature.playlist.ui.api.view.skeleton.SkeletonPlaylistTrackCard
import and.degilevich.dream.shared.foundation.compose.ext.Space
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.SkeletonCrossfade
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun RecentlyPlayedView(
    state: RecentlyPlayedUIState,
    modifier: Modifier = Modifier,
    onIntent: (RecentlyPlayedIntent) -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier
                .testTag(RecentlyPlayedViewSemantic.TEST_TAG_TITLE)
                .padding(horizontal = 16.dp),
            text = stringResource(Res.strings.title_recently_played),
            color = Theme.colors.text.primary,
            style = Theme.typography.h1
        )
        Space(8.dp)
        SkeletonCrossfade(
            skeleton = state.items,
            loadingContent = {
                RecentlyPlayedGrid(itemCount = RECENTLY_PLAYED_ITEM_COUNT) {
                    SkeletonPlaylistTrackCard(
                        modifier = Modifier.testTag(RecentlyPlayedViewSemantic.TEST_TAG_ITEM_SKELETON)
                    )
                }
            }
        ) { items ->
            RecentlyPlayedGrid(
                itemCount = items.size
            ) { index ->
                PlaylistTrackCard(
                    modifier = Modifier.testTag(RecentlyPlayedViewSemantic.TEST_TAG_ITEM),
                    data = items[index]
                ) { id ->
                    onIntent(
                        RecentlyPlayedIntent.OnTrackClicked(id = id)
                    )
                }
            }
        }
    }
}

@Composable
private fun RecentlyPlayedGrid(
    itemCount: Int,
    modifier: Modifier = Modifier,
    itemContent: @Composable (index: Int) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            ),
        horizontalArrangement = Arrangement.spacedBy(space = 8.dp)
    ) {
        repeat(RECENTLY_PLAYED_COLUMN_COUNT) { column ->
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(space = 8.dp)
            ) {
                repeat(RECENTLY_PLAYED_ROW_COUNT) { row ->
                    val index = column * RECENTLY_PLAYED_ROW_COUNT + row
                    if (index < itemCount) {
                        itemContent(index)
                    }
                }
            }
        }
    }
}

@LightDarkPreviews
@Composable
private fun RecentlyPlayedViewPreview(
    @PreviewParameter(RecentlyPlayedUIStatePreviewProvider::class)
    state: RecentlyPlayedUIState
) = ComposeAppTheme {
    RecentlyPlayedView(
        modifier = Modifier.themeBackground(),
        state = state
    ) {}
}

private const val RECENTLY_PLAYED_COLUMN_COUNT = 2
private const val RECENTLY_PLAYED_ROW_COUNT = 5
private const val RECENTLY_PLAYED_ITEM_COUNT = RECENTLY_PLAYED_COLUMN_COUNT * RECENTLY_PLAYED_ROW_COUNT
