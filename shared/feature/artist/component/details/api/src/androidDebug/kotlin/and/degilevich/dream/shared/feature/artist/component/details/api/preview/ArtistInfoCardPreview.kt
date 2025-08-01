package and.degilevich.dream.shared.feature.artist.component.details.api.preview

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.artist.component.details.api.design.ArtistInfoCard
import and.degilevich.dream.shared.feature.artist.component.details.api.preview.provider.ArtistInfoCardUIDataPreviewProvider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun ArtistInfoCardDarkPreview() {
    ComposeAppTheme(
        isDarkMode = true
    ) {
        ArtistInfoCard(
            modifier = Modifier.themeBackground(),
            data = ArtistInfoCardUIDataPreviewProvider.provide()
        )
    }
}

@Preview
@Composable
private fun ArtistInfoCardLightPreview() {
    ComposeAppTheme(
        isDarkMode = true
    ) {
        ArtistInfoCard(
            modifier = Modifier.themeBackground(),
            data = ArtistInfoCardUIDataPreviewProvider.provide()
        )
    }
}