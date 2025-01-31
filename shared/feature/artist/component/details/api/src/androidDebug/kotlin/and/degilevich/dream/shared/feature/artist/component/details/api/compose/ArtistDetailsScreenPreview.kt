package and.degilevich.dream.shared.feature.artist.component.details.api.compose

import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsUIState
import and.degilevich.dream.shared.feature.artist.compose.model.ArtistUIItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.collections.immutable.toImmutableList

@Preview
@Composable
fun ArtistDetailsScreenPreview() {
    ArtistDetailsScreen(
        state = ArtistDetailsUIState(
            artistName = "Artist name: Name",
            similarArtists = buildList {
                for (i in 1..10) {
                    add(
                        ArtistUIItem(
                            id = i.toString(),
                            name = "Artist $i"
                        )
                    )
                }
            }.toImmutableList()
        ),
        onIntent = { }
    )
}