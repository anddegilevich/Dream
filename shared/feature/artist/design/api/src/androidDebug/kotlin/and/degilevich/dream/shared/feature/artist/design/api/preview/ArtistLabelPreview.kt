package and.degilevich.dream.shared.feature.artist.design.api.preview

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.artist.design.api.design.ArtistLabel
import and.degilevich.dream.shared.feature.artist.design.api.preview.provider.ArtistLabelUIDataPreviewProvider
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@PreviewLightDark
@Composable
private fun ArtistLabelPreview() {
    ComposeAppTheme {
        ArtistLabel(
            modifier = Modifier.themeBackground(),
            data = ArtistLabelUIDataPreviewProvider.provide()
        ) { }
    }
}