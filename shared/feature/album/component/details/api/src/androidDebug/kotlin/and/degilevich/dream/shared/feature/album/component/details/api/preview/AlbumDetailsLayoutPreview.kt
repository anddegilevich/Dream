package and.degilevich.dream.shared.feature.album.component.details.api.preview

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.component.details.api.design.AlbumDetailsLayout
import and.degilevich.dream.shared.feature.album.component.details.api.preview.provider.AlbumDetailsLayoutUIDataPreviewProvider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun AlbumDetailsLayoutDarkPreview() {
    ComposeAppTheme(isDarkMode = true) {
        AlbumDetailsLayout(
            modifier = Modifier.themeBackground(),
            data = AlbumDetailsLayoutUIDataPreviewProvider.provide()
        )
    }
}

@Preview
@Composable
private fun AlbumDetailsLayoutLightPreview() {
    ComposeAppTheme(isDarkMode = false) {
        AlbumDetailsLayout(
            modifier = Modifier.themeBackground(),
            data = AlbumDetailsLayoutUIDataPreviewProvider.provide()
        )
    }
}