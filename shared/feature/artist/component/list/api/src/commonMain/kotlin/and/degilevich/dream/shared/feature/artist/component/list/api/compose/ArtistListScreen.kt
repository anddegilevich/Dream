package and.degilevich.dream.shared.feature.artist.component.list.api.compose

import and.degilevich.dream.shared.compose.foundation.ext.Space
import and.degilevich.dream.shared.feature.artist.component.list.api.component.ArtistListIntent
import and.degilevich.dream.shared.feature.artist.component.list.api.component.ArtistListUIState
import and.degilevich.dream.shared.feature.artist.compose.view.ArtistCard
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ArtistListScreen(
    state: ArtistListUIState,
    onIntent: (ArtistListIntent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Artists:")
        Space(height = 16.dp)
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(
                items = state.artists,
                key = { item -> item.id }
            ) { item ->
                ArtistCard(
                    item = item,
                    onCardClicked = { id ->
                        onIntent(ArtistListIntent.OnArtistClicked(id))
                    }
                )
            }
        }
    }
}