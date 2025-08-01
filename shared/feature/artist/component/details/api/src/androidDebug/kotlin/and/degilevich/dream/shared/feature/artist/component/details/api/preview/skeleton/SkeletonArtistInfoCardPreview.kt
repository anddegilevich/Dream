package and.degilevich.dream.shared.feature.artist.component.details.api.preview.skeleton

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.artist.component.details.api.design.skeleton.SkeletonArtistInfoCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun SkeletonArtistInfoCardDarkPreview() {
    ComposeAppTheme(isDarkMode = true) {
        SkeletonArtistInfoCard()
    }
}

@Preview
@Composable
private fun SkeletonArtistInfoCardLightPreview() {
    ComposeAppTheme(isDarkMode = false) {
        SkeletonArtistInfoCard()
    }
}