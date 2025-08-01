package and.degilevich.dream.shared.feature.album.component.details.api.design

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.system.button.IconButton
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsIntent
import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsUIState
import and.degilevich.dream.shared.feature.album.component.details.api.design.skeleton.SkeletonAlbumDetailsLayout
import and.degilevich.dream.shared.feature.artist.design.api.design.ArtistLabel
import and.degilevich.dream.shared.feature.artist.design.api.design.skeleton.SkeletonArtistLabel
import and.degilevich.dream.shared.foundation.compose.ext.Space
import and.degilevich.dream.shared.foundation.compose.ext.plus
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.SkeletonCrossfade
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.identifiedSkeletonItems
import and.degilevich.dream.shated.feature.track.design.api.design.TrackCard
import and.degilevich.dream.shated.feature.track.design.api.design.skeleton.SkeletonTrackCard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun AlbumDetailsScreen(
    state: AlbumDetailsUIState,
    modifier: Modifier = Modifier,
    onIntent: (AlbumDetailsIntent) -> Unit
) {
    LazyColumn(
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
            Column(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                IconButton(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(Res.images.ic_back)
                ) {
                    onIntent(AlbumDetailsIntent.OnBackClicked)
                }
                Space(height = 12.dp)
                SkeletonCrossfade(
                    skeleton = state.info,
                    loadingContent = {
                        SkeletonAlbumDetailsLayout(
                            modifier = Modifier.fillMaxWidth()
                        )
                    },
                    content = { data ->
                        AlbumDetailsLayout(
                            modifier = Modifier.fillMaxWidth(),
                            data = data
                        )
                    }
                )
            }
        }
        item {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(
                    start = 12.dp,
                    top = 20.dp,
                    end = 16.dp,
                    bottom = 20.dp
                ),
                horizontalArrangement = Arrangement.spacedBy(space = 12.dp)
            ) {
                identifiedSkeletonItems(
                    skeleton = state.artists,
                    loadingItemsCount = 1,
                    loadingItemContent = {
                        SkeletonArtistLabel(
                            modifier = Modifier.animateItem(),
                        )
                    },
                    itemContent = { artist ->
                        ArtistLabel(
                            modifier = Modifier.animateItem(),
                            data = artist
                        ) { artistId ->
                            onIntent(
                                AlbumDetailsIntent.OnArtistClicked(id = artistId)
                            )
                        }
                    }
                )
            }
        }
        identifiedSkeletonItems(
            skeleton = state.tracks,
            loadingItemsCount = 5,
            loadingItemContent = {
                SkeletonTrackCard(
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            },
            itemContent = { track ->
                TrackCard(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .animateItem()
                        .fillMaxWidth(),
                    data = track
                ) { trackId ->
                    onIntent(AlbumDetailsIntent.OnTrackClicked(id = trackId))
                }
            }
        )
    }
}