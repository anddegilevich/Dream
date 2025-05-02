package and.degilevich.dream.shared.feature.artist.component.details.api.design

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsUIState
import and.degilevich.dream.shared.feature.artist.design.api.model.ArtistCardUIData
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.collections.immutable.toImmutableList

@Preview
@Composable
fun ArtistDetailsScreenDarkPreview() {
    ComposeAppTheme(
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
    ComposeAppTheme(
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
        artistIconUrl = "",
        similarArtists = buildList {
            for (i in 1..10) {
                add(
                    ArtistCardUIData(
                        id = i.toString(),
                        name = "Artist $i"
                    )
                )
            }
        }.toImmutableList()
    )
}