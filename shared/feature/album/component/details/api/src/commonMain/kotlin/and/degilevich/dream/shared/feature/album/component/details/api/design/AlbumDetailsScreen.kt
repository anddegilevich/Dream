package and.degilevich.dream.shared.feature.album.component.details.api.design

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.system.button.IconButton
import and.degilevich.dream.shared.design.system.divider.TextCircleDivider
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsIntent
import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsUIState
import and.degilevich.dream.shared.feature.album.design.api.design.AlbumIcon
import and.degilevich.dream.shared.feature.artist.design.api.design.ArtistLabel
import and.degilevich.dream.shared.foundation.compose.ext.Space
import and.degilevich.dream.shared.foundation.compose.ext.identifiedItems
import and.degilevich.dream.shared.foundation.compose.ext.plus
import and.degilevich.dream.shated.feature.track.design.api.design.TrackCard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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

@Composable
fun AlbumDetailsScreen(
    state: AlbumDetailsUIState,
    modifier: Modifier = Modifier,
    onIntent: (AlbumDetailsIntent) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .themeBackground()
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(
            vertical = 12.dp,
            horizontal = 16.dp
        )
            .plus(WindowInsets.statusBars.asPaddingValues())
            .plus(WindowInsets.navigationBars.asPaddingValues()),
        verticalArrangement = Arrangement.spacedBy(space = 12.dp)
    ) {
        item {
            Column {
                IconButton(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(Res.images.ic_back)
                ) {
                    onIntent(AlbumDetailsIntent.OnBackClicked)
                }
                Space(height = 12.dp)
                AlbumIcon(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .size(260.dp),
                    iconUrl = state.iconUrl,
                )
                Space(height = 40.dp)
                Text(
                    text = state.name,
                    color = Theme.colors.text.primary,
                    style = Theme.typography.h2
                )
                Space(height = 12.dp)
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(space = 12.dp)
                ) {
                    identifiedItems(
                        items = state.artists
                    ) { artist ->
                        ArtistLabel(
                            data = artist
                        ) { artistId ->
                            onIntent(
                                AlbumDetailsIntent.OnArtistClicked(id = artistId)
                            )
                        }
                    }
                }
                Space(height = 8.dp)
                Row(
                    horizontalArrangement = Arrangement.spacedBy(space = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = state.type,
                        color = Theme.colors.text.secondary,
                        style = Theme.typography.label
                    )
                    TextCircleDivider(
                        color = Theme.colors.text.secondary
                    )
                    Text(
                        text = state.year,
                        color = Theme.colors.text.secondary,
                        style = Theme.typography.label
                    )
                }
                Space(height = 20.dp)
            }
        }
        identifiedItems(
            items = state.tracks
        ) { track ->
            TrackCard(
                modifier = Modifier.fillMaxWidth(),
                data = track
            ) { trackId ->
                onIntent(AlbumDetailsIntent.OnTrackClicked(id = trackId))
            }
        }
    }
}