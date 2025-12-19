package and.degilevich.dream.shared.feature.track.component.details.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsUIState
import and.degilevich.dream.shared.feature.track.component.details.api.design.TrackDetailsScreen
import and.degilevich.dream.shared.feature.track.component.details.api.preview.provider.TrackDetailsUIStatePreviewProvider
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewParameter

@PreviewLightDark
@Composable
private fun TrackDetailsScreenPreview(
    @PreviewParameter(TrackDetailsUIStatePreviewProvider::class)
    state: TrackDetailsUIState
) {
    ComposeAppTheme {
        TrackDetailsScreen(
            state = state
        ) { }
    }
}