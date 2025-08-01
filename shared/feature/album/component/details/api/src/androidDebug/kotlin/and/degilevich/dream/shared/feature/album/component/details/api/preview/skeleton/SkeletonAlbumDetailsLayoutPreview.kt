package and.degilevich.dream.shared.feature.album.component.details.api.preview.skeleton

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.component.details.api.design.skeleton.SkeletonAlbumDetailsLayout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun SkeletonAlbumDetailsLayoutDarkPreview() {
    ComposeAppTheme(isDarkMode = true) {
        SkeletonAlbumDetailsLayout(
            modifier = Modifier.themeBackground()
        )
    }
}

@Preview
@Composable
private fun SkeletonAlbumDetailsLayoutLightPreview() {
    ComposeAppTheme(isDarkMode = false) {
        SkeletonAlbumDetailsLayout(
            modifier = Modifier.themeBackground()
        )
    }
}