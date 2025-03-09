package and.degilevich.dream.shared.feature.artist.design.api.design

import and.degilevich.dream.shared.design.theme.api.DreamTheme
import and.degilevich.dream.shared.feature.artist.design.api.model.ArtistCardUIState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ArtistCardDarkPreview() {
    DreamTheme(
        isDarkMode = true
    ) {
        ArtistCard(
            state = providePreviewArtistUIItem(),
            onCardClicked = {}
        )
    }
}

@Preview
@Composable
fun ArtistCardLightPreview() {
    DreamTheme(
        isDarkMode = false
    ) {
        ArtistCard(
            state = providePreviewArtistUIItem(),
            onCardClicked = {}
        )
    }
}

private fun providePreviewArtistUIItem(): ArtistCardUIState {
    return ArtistCardUIState(
        id = "1",
        name = "Artist Name"
    )
}