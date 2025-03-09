package and.degilevich.dream.shared.feature.artist.component.list.api.design

import and.degilevich.dream.shared.design.theme.api.DreamTheme
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListUIState
import and.degilevich.dream.shared.feature.artist.design.api.model.ArtistCardUIState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.collections.immutable.toImmutableList

@Preview
@Composable
private fun ArtistListScreenDarkPreview() {
    DreamTheme(
        isDarkMode = true
    ) {
        ArtistListScreen(
            state = providePreviewArtistListUIState(),
            onIntent = {}
        )
    }
}

@Preview
@Composable
private fun ArtistListScreenLightPreview() {
    DreamTheme(
        isDarkMode = false
    ) {
        ArtistListScreen(
            state = providePreviewArtistListUIState(),
            onIntent = {}
        )
    }
}

@Suppress("MagicNumber")
private fun providePreviewArtistListUIState(): ArtistListUIState {
    return ArtistListUIState(
        artistCount = "10 Artists",
        artists = buildList {
            for (i in 1..10) {
                add(
                    ArtistCardUIState(
                        id = i.toString(),
                        name = "Artist $i"
                    )
                )
            }
        }.toImmutableList()
    )
}