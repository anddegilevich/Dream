package and.degilevich.dream.shared.feature.artist.component.list.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.artist.component.list.api.design.ArtistListScreen
import and.degilevich.dream.shared.feature.artist.component.list.api.preview.provider.ArtistListUIStatePreviewProvider
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun ArtistListScreenDarkPreview() {
    ComposeAppTheme(
        isDarkMode = true
    ) {
        ArtistListScreen(
            state = ArtistListUIStatePreviewProvider.provide(),
            onIntent = {}
        )
    }
}

@Preview
@Composable
private fun ArtistListScreenLightPreview() {
    ComposeAppTheme(
        isDarkMode = false
    ) {
        ArtistListScreen(
            state = ArtistListUIStatePreviewProvider.provide(),
            onIntent = {}
        )
    }
}
