package and.degilevich.dream.shared.feature.artist.component.details.api.preview

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.artist.component.details.api.design.ArtistInfoLayout
import and.degilevich.dream.shared.feature.artist.component.details.api.preview.provider.ArtistInfoLayoutUIDataPreviewProvider
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@PreviewLightDark
@Composable
private fun ArtistInfoLayoutPreview() {
    ComposeAppTheme {
        ArtistInfoLayout(
            modifier = Modifier.themeBackground(),
            data = ArtistInfoLayoutUIDataPreviewProvider.provide()
        )
    }
}