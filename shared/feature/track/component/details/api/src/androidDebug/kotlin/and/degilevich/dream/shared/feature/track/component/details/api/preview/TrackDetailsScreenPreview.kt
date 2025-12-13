package and.degilevich.dream.shared.feature.track.component.details.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.track.component.details.api.design.TrackDetailsScreen
import and.degilevich.dream.shared.feature.track.component.details.api.preview.provider.TrackDetailsUIStatePreviewProvider
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.runtime.Composable

@PreviewLightDark
@Composable
private fun TrackDetailsScreenPreview() {
    ComposeAppTheme {
        TrackDetailsScreen(
            state = TrackDetailsUIStatePreviewProvider.provide()
        ) { }
    }
}

@PreviewLightDark
@Composable
private fun SkeletonTrackDetailsScreenPreview() {
    ComposeAppTheme {
        TrackDetailsScreen(
            state = TrackDetailsUIStatePreviewProvider.provideSkeleton()
        ) { }
    }
}