package and.degilevich.dream.shared.feature.artist.component.details.api.compose

import and.degilevich.dream.shared.compose.foundation.ext.Space
import and.degilevich.dream.shared.feature.artist.component.details.api.component.ArtistDetailsIntent
import and.degilevich.dream.shared.feature.artist.component.details.api.component.ArtistDetailsUIState
import and.degilevich.dream.shared.feature.artist.compose.view.ArtistCard
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ArtistDetailsScreen(
    state: ArtistDetailsUIState,
    onIntent: (ArtistDetailsIntent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Artist name: ${state.artistName}"
        )
        Space(height = 16.dp)
        TextButton(
            onClick = {
                onIntent(ArtistDetailsIntent.OnSubscribeClicked())
            }
        ) {
            Text(text = "Subscribe")
        }
        Space(height = 16.dp)
        Text(
            text = "Similar artists"
        )
        Space(height = 16.dp)
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(
                items = state.similarArtists,
                key = { item -> item.id }
            ) { item ->
                ArtistCard(
                    item = item,
                    onCardClicked = { id ->
                        onIntent(ArtistDetailsIntent.OnSimilarArtistClicked(id))
                    }
                )
            }
        }
    }
}