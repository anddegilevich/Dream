package and.degilevich.dream.shared.feature.album.design.api.preview

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.design.api.design.AlbumCard
import and.degilevich.dream.shared.feature.album.design.api.preview.provider.AlbumCardUIDataPreviewProvider
import and.degilevich.dream.shared.foundation.compose.preview.DayNightPreviews
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@DayNightPreviews
@Composable
private fun AlbumCardPreview() {
    ComposeAppTheme {
        AlbumCard(
            modifier = Modifier.themeBackground(),
            data = AlbumCardUIDataPreviewProvider.provide(),
        ) {}
    }
}