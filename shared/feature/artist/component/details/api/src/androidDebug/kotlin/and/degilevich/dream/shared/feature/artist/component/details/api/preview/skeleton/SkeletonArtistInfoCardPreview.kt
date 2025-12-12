package and.degilevich.dream.shared.feature.artist.component.details.api.preview.skeleton

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.artist.component.details.api.design.skeleton.SkeletonArtistInfoCard
import and.degilevich.dream.shared.foundation.compose.preview.DayNightPreviews
import androidx.compose.runtime.Composable

@DayNightPreviews
@Composable
private fun SkeletonArtistInfoCardPreview() {
    ComposeAppTheme {
        SkeletonArtistInfoCard()
    }
}