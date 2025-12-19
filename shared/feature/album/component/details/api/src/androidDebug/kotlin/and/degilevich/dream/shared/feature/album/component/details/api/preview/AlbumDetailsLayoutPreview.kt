package and.degilevich.dream.shared.feature.album.component.details.api.preview

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsLayoutUIData
import and.degilevich.dream.shared.feature.album.component.details.api.design.AlbumDetailsLayout
import and.degilevich.dream.shared.feature.album.component.details.api.preview.provider.AlbumDetailsLayoutUIDataPreviewProvider
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter

@PreviewLightDark
@Composable
private fun AlbumDetailsLayoutPreview(
    @PreviewParameter(AlbumDetailsLayoutUIDataPreviewProvider::class)
    data: AlbumDetailsLayoutUIData
) {
    ComposeAppTheme {
        AlbumDetailsLayout(
            modifier = Modifier.themeBackground(),
            data = data
        )
    }
}