package and.degilevich.dream.shared.feature.artist.component.details.api.design

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.system.button.IconButton
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsIntent
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsUIState
import and.degilevich.dream.shared.foundation.compose.ext.Space
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.feature.album.design.api.design.AlbumCard
import and.degilevich.dream.shared.feature.album.design.api.design.skeleton.SkeletonAlbumCard
import and.degilevich.dream.shared.feature.artist.component.details.api.design.skeleton.SkeletonArtistInfoCard
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
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun ArtistDetailsScreen(
    state: ArtistDetailsUIState,
    onIntent: (ArtistDetailsIntent) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .themeBackground()
            .fillMaxSize(),
        contentPadding = PaddingValues(
            top = 12.dp,
            bottom = 20.dp
        )
            .plus(WindowInsets.statusBars.asPaddingValues())
            .plus(WindowInsets.navigationBars.asPaddingValues())
    ) {
        item {
            Column(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                IconButton(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(Res.images.ic_back)
                ) {
                    onIntent(ArtistDetailsIntent.OnBackClicked)
                }
                Space(height = 12.dp)
                SkeletonCrossfade(
                    skeleton = state.info,
                    loadingContent = {
                        SkeletonArtistInfoCard(
                            modifier = Modifier.fillMaxWidth(),
                        )
                    },
                    content = { data ->
                        ArtistInfoLayout(
                            modifier = Modifier.fillMaxWidth(),
                            data = data
                        )
                    }
                )
                Space(height = 20.dp)
                Text(
                    text = stringResource(Res.strings.title_top_tracks),
                    color = Theme.colors.text.primary,
                    style = Theme.typography.h3
                )
                Space(height = 4.dp)
            }
        }
        identifiedSkeletonItems(
            skeleton = state.topTracks,
            loadingItemsCount = 5,
            loadingItemContent = {
                SkeletonTrackCard(
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                )
            },
            itemContent = { track ->
                TrackCard(
                    modifier = Modifier
                        .animateItem()
                        .padding(top = 12.dp)
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    data = track
                ) { id ->
                    onIntent(ArtistDetailsIntent.OnTrackClicked(id = id))
                }
            }
        )
        item {
            Column {
                Space(height = 20.dp)
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = stringResource(Res.strings.title_albums),
                    color = Theme.colors.text.primary,
                    style = Theme.typography.h3
                )
                Space(height = 8.dp)
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(
                        horizontal = 16.dp,
                        vertical = 8.dp
                    ),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    identifiedSkeletonItems(
                        skeleton = state.albums,
                        loadingItemsCount = 5,
                        loadingItemContent = { SkeletonAlbumCard() },
                        itemContent = { album ->
                            AlbumCard(
                                modifier = Modifier.animateItem(),
                                data = album,
                                onClicked = { id ->
                                    onIntent(
                                        ArtistDetailsIntent.OnAlbumClicked(id = id)
                                    )
                                }
                            )
                        }
                    )
                }
            }
        }
    }
}