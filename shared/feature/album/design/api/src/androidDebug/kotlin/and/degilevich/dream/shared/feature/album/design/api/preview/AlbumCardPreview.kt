package and.degilevich.dream.shared.feature.album.design.api.preview

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.design.api.design.AlbumCard
import and.degilevich.dream.shared.feature.album.design.api.preview.provider.AlbumCardUIDataPreviewProvider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun AlbumCardDarkPreview() {
    ComposeAppTheme(
        isDarkMode = true
    ) {
        AlbumCard(
            modifier = Modifier.themeBackground(),
            data = AlbumCardUIDataPreviewProvider.provide(),
        ) {}
    }
}

@Preview
@Composable
fun AlbumCardLightPreview() {
    ComposeAppTheme(
        isDarkMode = false
    ) {
        AlbumCard(
            modifier = Modifier.themeBackground(),
            data = AlbumCardUIDataPreviewProvider.provide(),
        ) {}
    }
}