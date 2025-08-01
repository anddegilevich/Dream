package and.degilevich.dream.shated.feature.track.design.api.preview.skeleton

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shated.feature.track.design.api.design.skeleton.SkeletonTrackCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun SkeletonTrackCardDarkPreview() {
    ComposeAppTheme(isDarkMode = true) {
        SkeletonTrackCard(
            modifier = Modifier.themeBackground()
        )
    }
}

@Preview
@Composable
private fun SkeletonTrackCardLightPreview() {
    ComposeAppTheme(isDarkMode = false) {
        SkeletonTrackCard(
            modifier = Modifier.themeBackground()
        )
    }
}