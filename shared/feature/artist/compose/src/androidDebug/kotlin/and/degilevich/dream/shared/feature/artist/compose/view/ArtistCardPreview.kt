package and.degilevich.dream.shared.feature.artist.compose.view

import and.degilevich.dream.shared.feature.artist.compose.model.ArtistUIItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ArtistCardPreview() {
    ArtistCard(
        item = ArtistUIItem(
            id = "1",
            name = "Artist Name"
        ),
        onCardClicked = {}
    )
}