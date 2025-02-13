package and.degilevich.dream.shared.feature.artist.component.list.api.compose

import and.degilevich.dream.shared.compose.theme.api.DreamTheme
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListUIState
import and.degilevich.dream.shared.feature.artist.compose.model.ArtistUIItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.collections.immutable.toImmutableList

@Preview
@Composable
private fun ArtistListScreenPreview() {
    DreamTheme {
        ArtistListScreen(
            state = ArtistListUIState(
                artistCount = "10 Artists",
                artists = buildList {
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
            onIntent = {}
        )
    }
}