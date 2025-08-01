package and.degilevich.dream.shared.feature.artist.design.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.artist.design.api.design.ArtistIconPlaceholder
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
private fun ArtistIconPlaceholderDarkPreview() {
    ComposeAppTheme(isDarkMode = true) {
        ArtistIconPlaceholder(
            modifier = Modifier.size(64.dp)
        )
    }
}

@Preview
@Composable
private fun ArtistIconPlaceholderLightPreview() {
    ComposeAppTheme(isDarkMode = false) {
        ArtistIconPlaceholder(
            modifier = Modifier.size(64.dp)
        )
    }
}