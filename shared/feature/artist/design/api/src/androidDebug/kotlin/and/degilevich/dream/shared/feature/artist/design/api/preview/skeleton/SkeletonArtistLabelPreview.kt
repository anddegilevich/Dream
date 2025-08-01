package and.degilevich.dream.shared.feature.artist.design.api.preview.skeleton

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.artist.design.api.design.skeleton.SkeletonArtistLabel
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun SkeletonArtistLabelDarkPreview() {
    ComposeAppTheme(isDarkMode = true) {
        SkeletonArtistLabel(
            modifier = Modifier.themeBackground()
        )
    }
}

@Preview
@Composable
private fun SkeletonArtistLabelLightPreview() {
    ComposeAppTheme(isDarkMode = false) {
        SkeletonArtistLabel(
            modifier = Modifier.themeBackground()
        )
    }
}