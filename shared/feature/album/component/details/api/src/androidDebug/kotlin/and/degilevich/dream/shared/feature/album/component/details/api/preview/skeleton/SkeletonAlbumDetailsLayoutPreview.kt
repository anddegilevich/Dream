package and.degilevich.dream.shared.feature.album.component.details.api.preview.skeleton

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.component.details.api.design.skeleton.SkeletonAlbumDetailsLayout
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@PreviewLightDark
@Composable
private fun SkeletonAlbumDetailsLayoutPreview() {
    ComposeAppTheme {
        SkeletonAlbumDetailsLayout(
            modifier = Modifier.themeBackground()
        )
    }
}