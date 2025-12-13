package and.degilevich.dream.shared.feature.artist.component.details.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.artist.component.details.api.design.ArtistDetailsScreen
import and.degilevich.dream.shared.feature.artist.component.details.api.preview.provider.ArtistDetailsUIStatePreviewProvider
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.runtime.Composable

@PreviewLightDark
@Composable
private fun ArtistDetailsScreenPreview() {
    ComposeAppTheme {
        ArtistDetailsScreen(
            state = ArtistDetailsUIStatePreviewProvider.provide()
        ) { }
    }
}

@PreviewLightDark
@Composable
private fun SkeletonArtistDetailsScreenPreview() {
    ComposeAppTheme {
        ArtistDetailsScreen(
            state = ArtistDetailsUIStatePreviewProvider.provideSkeleton()
        ) { }
    }
}