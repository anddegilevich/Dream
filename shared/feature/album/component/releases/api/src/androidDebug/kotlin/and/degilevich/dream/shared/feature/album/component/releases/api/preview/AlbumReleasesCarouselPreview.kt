package and.degilevich.dream.shared.feature.album.component.releases.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.component.releases.api.design.AlbumReleasesCarousel
import and.degilevich.dream.shared.feature.album.component.releases.api.preview.provider.AlbumReleasesUIStatePreviewProvider
import and.degilevich.dream.shared.foundation.compose.preview.DayNightPreviews
import androidx.compose.runtime.Composable

@DayNightPreviews
@Composable
private fun AlbumReleasesCarouselPreview() {
    ComposeAppTheme {
        AlbumReleasesCarousel(
            state = AlbumReleasesUIStatePreviewProvider.provide(),
            onIntent = {}
        )
    }
}

@DayNightPreviews
@Composable
private fun SkeletonAlbumReleasesCarouselPreview() {
    ComposeAppTheme {
        AlbumReleasesCarousel(
            state = AlbumReleasesUIStatePreviewProvider.provideSkeleton(),
            onIntent = {}
        )
    }
}