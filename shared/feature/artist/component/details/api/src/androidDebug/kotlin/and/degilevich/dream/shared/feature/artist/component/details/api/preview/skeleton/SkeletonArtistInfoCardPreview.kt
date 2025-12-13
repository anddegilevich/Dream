package and.degilevich.dream.shared.feature.artist.component.details.api.preview.skeleton

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.artist.component.details.api.design.skeleton.SkeletonArtistInfoCard
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.runtime.Composable

@PreviewLightDark
@Composable
private fun SkeletonArtistInfoCardPreview() {
    ComposeAppTheme {
        SkeletonArtistInfoCard()
    }
}