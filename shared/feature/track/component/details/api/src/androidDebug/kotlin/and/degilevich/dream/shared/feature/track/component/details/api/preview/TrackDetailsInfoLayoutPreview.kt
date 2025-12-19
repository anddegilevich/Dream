package and.degilevich.dream.shared.feature.track.component.details.api.preview

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsInfoLayoutUIData
import and.degilevich.dream.shared.feature.track.component.details.api.design.TrackDetailsInfoLayout
import and.degilevich.dream.shared.feature.track.component.details.api.preview.provider.TrackDetailsInfoLayoutUIDataPreviewProvider
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter

@PreviewLightDark
@Composable
private fun TrackDetailsInfoLayoutPreview(
    @PreviewParameter(TrackDetailsInfoLayoutUIDataPreviewProvider::class)
    data: TrackDetailsInfoLayoutUIData
) {
    ComposeAppTheme {
        TrackDetailsInfoLayout(
            modifier = Modifier.themeBackground(),
            data = data
        )
    }
}