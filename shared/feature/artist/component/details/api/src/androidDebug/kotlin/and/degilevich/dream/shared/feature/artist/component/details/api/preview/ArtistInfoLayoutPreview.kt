package and.degilevich.dream.shared.feature.artist.component.details.api.preview

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.artist.component.details.api.design.ArtistInfoLayout
import and.degilevich.dream.shared.feature.artist.component.details.api.preview.provider.ArtistInfoLayoutUIDataPreviewProvider
import and.degilevich.dream.shared.foundation.compose.preview.DayNightPreviews
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@DayNightPreviews
@Composable
private fun ArtistInfoLayoutPreview() {
    ComposeAppTheme {
        ArtistInfoLayout(
            modifier = Modifier.themeBackground(),
            data = ArtistInfoLayoutUIDataPreviewProvider.provide()
        )
    }
}