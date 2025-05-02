package and.degilevich.dream.shared.feature.artist.design.api.design

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun ArtistIconDarkPreview() {
    ComposeAppTheme(
        isDarkMode = true
    ) {
        ArtistIcon(
            modifier = Modifier.size(100.dp),
            iconUrl = ""
        )
    }
}

@Preview
@Composable
fun ArtistIconLightPreview() {
    ComposeAppTheme(
        isDarkMode = false
    ) {
        ArtistIcon(
            modifier = Modifier.size(100.dp),
            iconUrl = ""
        )
    }
}