package and.degilevich.dream.shared.feature.album.component.details.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.component.details.api.design.AlbumDetailsScreen
import and.degilevich.dream.shared.feature.album.component.details.api.preview.provider.AlbumDetailsUIStatePreviewProvider
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.runtime.Composable

@PreviewLightDark
@Composable
private fun AlbumDetailsScreenPreview() {
    ComposeAppTheme {
        AlbumDetailsScreen(
            state = AlbumDetailsUIStatePreviewProvider.provide()
        ) { }
    }
}

@PreviewLightDark
@Composable
private fun SkeletonAlbumDetailsScreenPreview() {
    ComposeAppTheme {
        AlbumDetailsScreen(
            state = AlbumDetailsUIStatePreviewProvider.provideSkeleton()
        ) { }
    }
}