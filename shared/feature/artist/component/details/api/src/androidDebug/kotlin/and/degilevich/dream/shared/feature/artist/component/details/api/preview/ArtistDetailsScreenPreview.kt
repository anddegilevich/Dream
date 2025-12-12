package and.degilevich.dream.shared.feature.artist.component.details.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.artist.component.details.api.design.ArtistDetailsScreen
import and.degilevich.dream.shared.feature.artist.component.details.api.preview.provider.ArtistDetailsUIStatePreviewProvider
import and.degilevich.dream.shared.foundation.compose.preview.DayNightPreviews
import androidx.compose.runtime.Composable

@DayNightPreviews
@Composable
private fun ArtistDetailsScreenPreview() {
    ComposeAppTheme {
        ArtistDetailsScreen(
            state = ArtistDetailsUIStatePreviewProvider.provide()
        ) { }
    }
}

@DayNightPreviews
@Composable
private fun SkeletonArtistDetailsScreenPreview() {
    ComposeAppTheme {
        ArtistDetailsScreen(
            state = ArtistDetailsUIStatePreviewProvider.provideSkeleton()
        ) { }
    }
}