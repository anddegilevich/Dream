package and.degilevich.dream.shared.feature.album.design.api.preview.skeleton

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.design.api.design.skeleton.SkeletonAlbumCard
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.runtime.Composable

@PreviewLightDark
@Composable
private fun SkeletonAlbumCardPreview() {
    ComposeAppTheme {
        SkeletonAlbumCard()
    }
}