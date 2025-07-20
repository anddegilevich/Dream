package and.degilevich.dream.shared.feature.artist.design.api.preview

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.artist.design.api.design.ArtistLabel
import and.degilevich.dream.shared.feature.artist.design.api.preview.provider.ArtistLabelUIDataPreviewProvider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ArtistLabelDarkPreview() {
    ComposeAppTheme(
        isDarkMode = true
    ) {
        ArtistLabel(
            modifier = Modifier.themeBackground(),
            data = ArtistLabelUIDataPreviewProvider.provide()
        ) { }
    }
}

@Preview
@Composable
fun ArtistLabelLightPreview() {
    ComposeAppTheme(
        isDarkMode = false
    ) {
        ArtistLabel(
            modifier = Modifier.themeBackground(),
            data = ArtistLabelUIDataPreviewProvider.provide()
        ) { }
    }
}