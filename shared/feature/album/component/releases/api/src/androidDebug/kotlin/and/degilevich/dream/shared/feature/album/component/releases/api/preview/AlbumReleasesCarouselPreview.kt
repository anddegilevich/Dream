package and.degilevich.dream.shared.feature.album.component.releases.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesUIState
import and.degilevich.dream.shared.feature.album.component.releases.api.design.AlbumReleasesCarousel
import and.degilevich.dream.shared.feature.album.component.releases.api.preview.provider.AlbumReleasesUIStatePreviewProvider
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewParameter

@PreviewLightDark
@Composable
private fun AlbumReleasesCarouselPreview(
    @PreviewParameter(AlbumReleasesUIStatePreviewProvider::class)
    state: AlbumReleasesUIState
) {
    ComposeAppTheme {
        AlbumReleasesCarousel(
            state = state
        ) {}
    }
}