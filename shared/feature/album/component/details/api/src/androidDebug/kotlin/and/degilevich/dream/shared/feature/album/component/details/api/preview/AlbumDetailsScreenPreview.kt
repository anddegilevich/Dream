package and.degilevich.dream.shared.feature.album.component.details.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.component.details.api.design.AlbumDetailsScreen
import and.degilevich.dream.shared.feature.album.component.details.api.preview.provider.AlbumDetailsUIStatePreviewProvider
import and.degilevich.dream.shared.foundation.compose.preview.DayNightPreviews
import androidx.compose.runtime.Composable

@DayNightPreviews
@Composable
private fun AlbumDetailsScreenPreview() {
    ComposeAppTheme {
        AlbumDetailsScreen(
            state = AlbumDetailsUIStatePreviewProvider.provide()
        ) { }
    }
}

@DayNightPreviews
@Composable
private fun SkeletonAlbumDetailsScreenPreview() {
    ComposeAppTheme {
        AlbumDetailsScreen(
            state = AlbumDetailsUIStatePreviewProvider.provideSkeleton()
        ) { }
    }
}