package and.degilevich.dream.shated.feature.track.design.api.preview

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shated.feature.track.design.api.design.TrackCard
import and.degilevich.dream.shated.feature.track.design.api.preview.provider.TrackCardUIDataPreviewProvider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun TrackCardDarkPreview() {
    ComposeAppTheme(
        isDarkMode = true
    ) {
        TrackCard(
            modifier = Modifier.themeBackground(),
            data = TrackCardUIDataPreviewProvider.provide()
        ) { }
    }
}

@Preview
@Composable
private fun TrackCardLightPreview() {
    ComposeAppTheme(
        isDarkMode = false
    ) {
        TrackCard(
            modifier = Modifier.themeBackground(),
            data = TrackCardUIDataPreviewProvider.provide()
        ) { }
    }
}