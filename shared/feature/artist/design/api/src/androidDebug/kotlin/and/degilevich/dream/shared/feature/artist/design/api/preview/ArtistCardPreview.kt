package and.degilevich.dream.shared.feature.artist.design.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.artist.design.api.design.ArtistCard
import and.degilevich.dream.shared.feature.artist.design.api.preview.provider.ArtistCardUIDataPreviewProvider
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ArtistCardDarkPreview() {
    ComposeAppTheme(
        isDarkMode = true
    ) {
        ArtistCard(
            data = ArtistCardUIDataPreviewProvider.provide(),
            onCardClicked = {}
        )
    }
}

@Preview
@Composable
fun ArtistCardLightPreview() {
    ComposeAppTheme(
        isDarkMode = false
    ) {
        ArtistCard(
            data = ArtistCardUIDataPreviewProvider.provide(),
            onCardClicked = {}
        )
    }
}