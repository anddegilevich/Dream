package and.degilevich.dream.shared.feature.album.design.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.design.api.design.AlbumIconPlaceholder
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
private fun AlbumIconPlaceholderDarkPreview() {
    ComposeAppTheme(isDarkMode = true) {
        AlbumIconPlaceholder(
            modifier = Modifier.size(64.dp)
        )
    }
}

@Preview
@Composable
private fun AlbumIconPlaceholderLightPreview() {
    ComposeAppTheme(isDarkMode = false) {
        AlbumIconPlaceholder(
            modifier = Modifier.size(64.dp)
        )
    }
}