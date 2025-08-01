package and.degilevich.dream.shared.feature.album.component.details.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.component.details.api.design.AlbumDetailsScreen
import and.degilevich.dream.shared.feature.album.component.details.api.preview.provider.AlbumDetailsUIStatePreviewProvider
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun AlbumDetailsScreenDarkPreview() {
    ComposeAppTheme(
        isDarkMode = true
    ) {
        AlbumDetailsScreen(
            state = AlbumDetailsUIStatePreviewProvider.provide()
        ) { }
    }
}

@Preview
@Composable
fun AlbumDetailsScreenLightPreview() {
    ComposeAppTheme(
        isDarkMode = false
    ) {
        AlbumDetailsScreen(
            state = AlbumDetailsUIStatePreviewProvider.provide()
        ) { }
    }
}

@Preview
@Composable
fun SkeletonAlbumDetailsScreenDarkPreview() {
    ComposeAppTheme(
        isDarkMode = true
    ) {
        AlbumDetailsScreen(
            state = AlbumDetailsUIStatePreviewProvider.provideSkeleton()
        ) { }
    }
}

@Preview
@Composable
fun SkeletonAlbumDetailsScreenLightPreview() {
    ComposeAppTheme(
        isDarkMode = false
    ) {
        AlbumDetailsScreen(
            state = AlbumDetailsUIStatePreviewProvider.provideSkeleton()
        ) { }
    }
}