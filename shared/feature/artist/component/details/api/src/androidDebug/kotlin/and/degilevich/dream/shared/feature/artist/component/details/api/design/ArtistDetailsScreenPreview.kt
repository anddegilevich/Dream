package and.degilevich.dream.shared.feature.artist.component.details.api.design

import and.degilevich.dream.shared.design.theme.api.DreamTheme
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsUIState
import and.degilevich.dream.shared.feature.artist.design.api.model.ArtistCardUIState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.collections.immutable.toImmutableList

@Preview
@Composable
fun ArtistDetailsScreenDarkPreview() {
    DreamTheme(
        isDarkMode = true
    ) {
        ArtistDetailsScreen(
            state = providePreviewArtistDetailsUIState(),
            onIntent = { }
        )
    }
}

@Preview
@Composable
fun ArtistDetailsScreenLightPreview() {
    DreamTheme(
        isDarkMode = false
    ) {
        ArtistDetailsScreen(
            state = providePreviewArtistDetailsUIState(),
            onIntent = { }
        )
    }
}

@Suppress("MagicNumber")
private fun providePreviewArtistDetailsUIState(): ArtistDetailsUIState {
    return ArtistDetailsUIState(
        artistName = "Artist name: Name",
        similarArtists = buildList {
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