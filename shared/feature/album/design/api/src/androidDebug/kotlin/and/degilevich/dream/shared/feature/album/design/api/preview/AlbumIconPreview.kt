package and.degilevich.dream.shared.feature.album.design.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.design.api.design.AlbumIcon
import and.degilevich.dream.shared.foundation.compose.preview.DayNightPreviews
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@DayNightPreviews
@Composable
private fun AlbumIconPreview() {
    ComposeAppTheme {
        AlbumIcon(
            modifier = Modifier.size(152.dp),
            iconUrl = ""
        )
    }
}