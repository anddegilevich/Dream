package and.degilevich.dream.shared.feature.album.design.api.preview

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.design.api.design.AlbumCard
import and.degilevich.dream.shared.feature.album.design.api.preview.provider.AlbumCardUIDataPreviewProvider
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@PreviewLightDark
@Composable
private fun AlbumCardPreview() {
    ComposeAppTheme {
        AlbumCard(
            modifier = Modifier.themeBackground(),
            data = AlbumCardUIDataPreviewProvider.provide(),
        ) {}
    }
}