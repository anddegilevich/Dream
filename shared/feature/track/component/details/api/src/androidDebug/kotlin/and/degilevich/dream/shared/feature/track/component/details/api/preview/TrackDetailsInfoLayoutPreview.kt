package and.degilevich.dream.shared.feature.track.component.details.api.preview

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.track.component.details.api.design.TrackDetailsInfoLayout
import and.degilevich.dream.shared.feature.track.component.details.api.preview.provider.TrackDetailsInfoLayoutUIDataPreviewProvider
import and.degilevich.dream.shared.foundation.compose.preview.DayNightPreviews
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@DayNightPreviews
@Composable
private fun TrackDetailsInfoLayoutPreview() {
    ComposeAppTheme {
        TrackDetailsInfoLayout(
            modifier = Modifier.themeBackground(),
            data = TrackDetailsInfoLayoutUIDataPreviewProvider.provide()
        )
    }
}