package and.degilevich.dream.shared.feature.album.design.api.design

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.design.api.model.AlbumCardUIData
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun AlbumCardDarkPreview() {
    ComposeAppTheme(
        isDarkMode = true
    ) {
        AlbumCard(
            state = providePreviewAlbumUIItem(),
            onCardClicked = {}
        )
    }
}

@Preview
@Composable
fun AlbumCardLightPreview() {
    ComposeAppTheme(
        isDarkMode = false
    ) {
        AlbumCard(
            state = providePreviewAlbumUIItem(),
            onCardClicked = {}
        )
    }
}

private fun providePreviewAlbumUIItem(): AlbumCardUIData {
    return AlbumCardUIData.empty().copy(
        name = "Album",
        artists = "Artist"
    )
}