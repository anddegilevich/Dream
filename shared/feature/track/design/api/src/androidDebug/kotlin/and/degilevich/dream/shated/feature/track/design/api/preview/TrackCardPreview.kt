package and.degilevich.dream.shated.feature.track.design.api.preview

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import androidx.compose.ui.tooling.preview.PreviewLightDark
import and.degilevich.dream.shated.feature.track.design.api.design.TrackCard
import and.degilevich.dream.shated.feature.track.design.api.preview.provider.TrackCardUIDataPreviewProvider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@PreviewLightDark
@Composable
private fun TrackCardPreview() {
    ComposeAppTheme {
        TrackCard(
            modifier = Modifier.themeBackground(),
            data = TrackCardUIDataPreviewProvider.provide()
        ) { }
    }
}