package and.degilevich.dream.shared.feature.search.design.api.preview

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.search.design.api.design.TrackSearchCard
import and.degilevich.dream.shared.feature.search.design.api.preview.provider.SearchCardUIDataPreviewProvider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun TrackSearchCardDarkPreview() {
    ComposeAppTheme(isDarkMode = true) {
        TrackSearchCard(
            modifier = Modifier.themeBackground(),
            data = SearchCardUIDataPreviewProvider.provideTrack()
        ) {}
    }
}

@Preview
@Composable
private fun TrackSearchCardLightPreview() {
    ComposeAppTheme(isDarkMode = false) {
        TrackSearchCard(
            modifier = Modifier.themeBackground(),
            data = SearchCardUIDataPreviewProvider.provideTrack()
        ) {}
    }
}