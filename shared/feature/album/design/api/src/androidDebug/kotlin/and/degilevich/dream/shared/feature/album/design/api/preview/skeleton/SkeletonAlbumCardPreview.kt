package and.degilevich.dream.shared.feature.album.design.api.preview.skeleton

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.design.api.design.skeleton.SkeletonAlbumCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun SkeletonAlbumCardDarkPreview() {
    ComposeAppTheme(isDarkMode = true) {
        SkeletonAlbumCard()
    }
}

@Preview
@Composable
private fun SkeletonAlbumCardLightPreview() {
    ComposeAppTheme(isDarkMode = false) {
        SkeletonAlbumCard()
    }
}