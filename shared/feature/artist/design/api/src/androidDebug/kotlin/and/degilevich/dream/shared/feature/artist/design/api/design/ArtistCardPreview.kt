package and.degilevich.dream.shared.feature.artist.design.api.design

import and.degilevich.dream.shared.design.theme.api.DreamTheme
import and.degilevich.dream.shared.feature.artist.design.api.model.ArtistUIItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ArtistCardDarkPreview() {
    DreamTheme(
        isDarkMode = true
    ) {
        ArtistCard(
            item = providePreviewArtistUIItem(),
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
            item = providePreviewArtistUIItem(),
            onCardClicked = {}
        )
    }
}

private fun providePreviewArtistUIItem(): ArtistUIItem {
    return ArtistUIItem(
        id = "1",
        name = "Artist Name"
    )
}