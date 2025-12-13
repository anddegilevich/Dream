package and.degilevich.dream.shared.feature.album.component.details.api.preview

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.component.details.api.design.AlbumDetailsLayout
import and.degilevich.dream.shared.feature.album.component.details.api.preview.provider.AlbumDetailsLayoutUIDataPreviewProvider
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@PreviewLightDark
@Composable
private fun AlbumDetailsLayoutPreview() {
    ComposeAppTheme {
        AlbumDetailsLayout(
            modifier = Modifier.themeBackground(),
            data = AlbumDetailsLayoutUIDataPreviewProvider.provide()
        )
    }
}