package and.degilevich.dream.shared.feature.artist.component.details.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.artist.component.details.api.design.ArtistDetailsScreen
import and.degilevich.dream.shared.feature.artist.component.details.api.preview.provider.ArtistDetailsUIStatePreviewProvider
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ArtistDetailsScreenDarkPreview() {
    ComposeAppTheme(
        isDarkMode = true
    ) {
        ArtistDetailsScreen(
            state = ArtistDetailsUIStatePreviewProvider.provide(),
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
            state = ArtistDetailsUIStatePreviewProvider.provide(),
            onIntent = { }
        )
    }
}