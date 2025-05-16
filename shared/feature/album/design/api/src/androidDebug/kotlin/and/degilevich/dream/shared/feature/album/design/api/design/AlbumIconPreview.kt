package and.degilevich.dream.shared.feature.album.design.api.design

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun AlbumIconDarkPreview() {
    ComposeAppTheme(
        isDarkMode = true
    ) {
        AlbumIcon(
            modifier = Modifier.size(152.dp),
            iconUrl = ""
        )
    }
}

@Preview
@Composable
fun AlbumIconLightPreview() {
    ComposeAppTheme(
        isDarkMode = false
    ) {
        AlbumIcon(
            modifier = Modifier.size(152.dp),
            iconUrl = ""
        )
    }
}