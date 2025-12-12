package and.degilevich.dream.shared.feature.album.design.api.preview.skeleton

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.design.api.design.skeleton.SkeletonAlbumCard
import and.degilevich.dream.shared.foundation.compose.preview.DayNightPreviews
import androidx.compose.runtime.Composable

@DayNightPreviews
@Composable
private fun SkeletonAlbumCardPreview() {
    ComposeAppTheme {
        SkeletonAlbumCard()
    }
}