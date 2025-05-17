package and.degilevich.dream.shared.feature.album.component.releases.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.component.releases.api.design.AlbumReleasesCarousel
import and.degilevich.dream.shared.feature.album.component.releases.api.preview.provider.AlbumReleasesUIStatePreviewProvider
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun AlbumReleasesCarouselDarkPreview() {
    ComposeAppTheme(
        isDarkMode = true
    ) {
        AlbumReleasesCarousel(
            state = AlbumReleasesUIStatePreviewProvider.provide(),
            onIntent = {}
        )
    }
}

@Preview
@Composable
private fun AlbumReleasesCarouselLightPreview() {
    ComposeAppTheme(
        isDarkMode = false
    ) {
        AlbumReleasesCarousel(
            state = AlbumReleasesUIStatePreviewProvider.provide(),
            onIntent = {}
        )
    }
}