package and.degilevich.dream.shared.feature.artist.component.list.api.compose

import and.degilevich.dream.shared.compose.foundation.ext.Space
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListIntent
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListUIState
import and.degilevich.dream.shared.feature.artist.compose.view.ArtistCard
import and.degilevich.dream.shared.resource.api.Res
import and.degilevich.dream.shared.resource.api.ic_duck
import and.degilevich.dream.shared.resource.api.title_artists
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

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
        Icon(
            modifier = Modifier
                .background(Color.Black)
                .size(65.dp),
            painter = painterResource(Res.drawable.ic_duck),
            tint = Color.White,
            contentDescription = null,
        )
        Space(height = 16.dp)
        Text(stringResource(Res.string.title_artists))
        Text(state.artistCount)
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