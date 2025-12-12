package and.degilevich.dream.shared.feature.track.component.details.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.track.component.details.api.design.TrackDetailsScreen
import and.degilevich.dream.shared.feature.track.component.details.api.preview.provider.TrackDetailsUIStatePreviewProvider
import and.degilevich.dream.shared.foundation.compose.preview.DayNightPreviews
import androidx.compose.runtime.Composable

@DayNightPreviews
@Composable
private fun TrackDetailsScreenPreview() {
    ComposeAppTheme {
        TrackDetailsScreen(
            state = TrackDetailsUIStatePreviewProvider.provide()
        ) { }
    }
}

@DayNightPreviews
@Composable
private fun SkeletonTrackDetailsScreenPreview() {
    ComposeAppTheme {
        TrackDetailsScreen(
            state = TrackDetailsUIStatePreviewProvider.provideSkeleton()
        ) { }
    }
}