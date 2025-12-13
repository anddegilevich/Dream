package and.degilevich.dream.shared.feature.album.design.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.design.api.design.AlbumIconPlaceholder
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@PreviewLightDark
@Composable
private fun AlbumIconPlaceholderPreview() {
    ComposeAppTheme {
        AlbumIconPlaceholder(
            modifier = Modifier.size(64.dp)
        )
    }
}