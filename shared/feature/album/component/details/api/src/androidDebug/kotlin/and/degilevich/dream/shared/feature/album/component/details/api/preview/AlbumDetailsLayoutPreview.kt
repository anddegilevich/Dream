package and.degilevich.dream.shared.feature.album.component.details.api.preview

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.component.details.api.design.AlbumDetailsLayout
import and.degilevich.dream.shared.feature.album.component.details.api.preview.provider.AlbumDetailsLayoutUIDataPreviewProvider
import and.degilevich.dream.shared.foundation.compose.preview.DayNightPreviews
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@DayNightPreviews
@Composable
private fun AlbumDetailsLayoutPreview() {
    ComposeAppTheme {
        AlbumDetailsLayout(
            modifier = Modifier.themeBackground(),
            data = AlbumDetailsLayoutUIDataPreviewProvider.provide()
        )
    }
}