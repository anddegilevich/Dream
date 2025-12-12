package and.degilevich.dream.shated.feature.track.design.api.preview

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.foundation.compose.preview.DayNightPreviews
import and.degilevich.dream.shated.feature.track.design.api.design.TrackCard
import and.degilevich.dream.shated.feature.track.design.api.preview.provider.TrackCardUIDataPreviewProvider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@DayNightPreviews
@Composable
private fun TrackCardPreview() {
    ComposeAppTheme {
        TrackCard(
            modifier = Modifier.themeBackground(),
            data = TrackCardUIDataPreviewProvider.provide()
        ) { }
    }
}