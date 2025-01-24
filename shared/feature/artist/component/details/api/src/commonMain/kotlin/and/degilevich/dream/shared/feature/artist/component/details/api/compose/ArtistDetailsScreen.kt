package and.degilevich.dream.shared.feature.artist.component.details.api.compose

import and.degilevich.dream.shared.feature.artist.component.details.api.component.ArtistDetailsIntent
import and.degilevich.dream.shared.feature.artist.component.details.api.component.ArtistDetailsUIState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ArtistDetailsScreen(
    state: ArtistDetailsUIState,
    onIntent: (ArtistDetailsIntent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Artist name: ${state.artistName}"
        )
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        TextButton(
            onClick = {
                onIntent(ArtistDetailsIntent.OnBackClicked())
            }
        ) {
            Text(text = "Back")
        }
    }
}