package and.degilevich.dream.shared.feature.artist.component.details.api.compose

import and.degilevich.dream.shared.feature.artist.component.details.api.component.ArtistDetailsUIState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ArtistDetailsScreenPreview() {
    ArtistDetailsScreen(
        state = ArtistDetailsUIState(
            artistName = "Name"
        ),
        onIntent = { }
    )
}