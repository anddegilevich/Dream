package and.degilevich.dream.shared.feature.track.component.details.api.preview.skeleton

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.track.component.details.api.design.skeleton.SkeletonTrackDetailsInfoLayout
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun SkeletonTrackDetailsInfoLayoutDarkPreview() {
    ComposeAppTheme(isDarkMode = true) {
        SkeletonTrackDetailsInfoLayout()
    }
}

@Preview
@Composable
private fun SkeletonTrackDetailsInfoLayoutLightPreview() {
    ComposeAppTheme(isDarkMode = false) {
        SkeletonTrackDetailsInfoLayout()
    }
}