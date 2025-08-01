package and.degilevich.dream.shared.feature.track.component.details.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.track.component.details.api.design.TrackDetailsScreen
import and.degilevich.dream.shared.feature.track.component.details.api.preview.provider.TrackDetailsUIStatePreviewProvider
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun TrackDetailsScreenDarkPreview() {
    ComposeAppTheme(isDarkMode = true) {
        TrackDetailsScreen(
            state = TrackDetailsUIStatePreviewProvider.provide()
        ) { }
    }
}

@Preview
@Composable
private fun TrackDetailsScreenLightPreview() {
    ComposeAppTheme(isDarkMode = false) {
        TrackDetailsScreen(
            state = TrackDetailsUIStatePreviewProvider.provide()
        ) { }
    }
}
@Preview
@Composable
private fun SkeletonTrackDetailsScreenDarkPreview() {
    ComposeAppTheme(isDarkMode = true) {
        TrackDetailsScreen(
            state = TrackDetailsUIStatePreviewProvider.provideSkeleton()
        ) { }
    }
}

@Preview
@Composable
private fun SkeletonTrackDetailsScreenLightPreview() {
    ComposeAppTheme(isDarkMode = false) {
        TrackDetailsScreen(
            state = TrackDetailsUIStatePreviewProvider.provideSkeleton()
        ) { }
    }
}