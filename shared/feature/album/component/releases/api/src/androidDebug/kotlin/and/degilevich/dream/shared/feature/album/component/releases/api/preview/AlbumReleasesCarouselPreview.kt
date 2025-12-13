package and.degilevich.dream.shared.feature.album.component.releases.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.component.releases.api.design.AlbumReleasesCarousel
import and.degilevich.dream.shared.feature.album.component.releases.api.preview.provider.AlbumReleasesUIStatePreviewProvider
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.runtime.Composable

@PreviewLightDark
@Composable
private fun AlbumReleasesCarouselPreview() {
    ComposeAppTheme {
        AlbumReleasesCarousel(
            state = AlbumReleasesUIStatePreviewProvider.provide(),
            onIntent = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun SkeletonAlbumReleasesCarouselPreview() {
    ComposeAppTheme {
        AlbumReleasesCarousel(
            state = AlbumReleasesUIStatePreviewProvider.provideSkeleton(),
            onIntent = {}
        )
    }
}