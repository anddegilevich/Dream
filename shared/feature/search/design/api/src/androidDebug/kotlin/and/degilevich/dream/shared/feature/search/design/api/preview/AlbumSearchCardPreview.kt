package and.degilevich.dream.shared.feature.search.design.api.preview

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.search.design.api.design.AlbumSearchCard
import and.degilevich.dream.shared.feature.search.design.api.preview.provider.SearchCardUIDataPreviewProvider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun AlbumSearchCardDarkPreview() {
    ComposeAppTheme(isDarkMode = true) {
        AlbumSearchCard(
            modifier = Modifier.themeBackground(),
            data = SearchCardUIDataPreviewProvider.provideAlbum()
        ) {}
    }
}

@Preview
@Composable
private fun AlbumSearchCardLightPreview() {
    ComposeAppTheme(isDarkMode = false) {
        AlbumSearchCard(
            modifier = Modifier.themeBackground(),
            data = SearchCardUIDataPreviewProvider.provideAlbum()
        ) {}
    }
}