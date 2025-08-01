package and.degilevich.dream.shared.feature.artist.component.details.api.preview

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.artist.component.details.api.design.ArtistInfoLayout
import and.degilevich.dream.shared.feature.artist.component.details.api.preview.provider.ArtistInfoLayoutUIDataPreviewProvider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun ArtistInfoLayoutDarkPreview() {
    ComposeAppTheme(
        isDarkMode = true
    ) {
        ArtistInfoLayout(
            modifier = Modifier.themeBackground(),
            data = ArtistInfoLayoutUIDataPreviewProvider.provide()
        )
    }
}

@Preview
@Composable
private fun ArtistInfoLayoutLightPreview() {
    ComposeAppTheme(
        isDarkMode = true
    ) {
        ArtistInfoLayout(
            modifier = Modifier.themeBackground(),
            data = ArtistInfoLayoutUIDataPreviewProvider.provide()
        )
    }
}