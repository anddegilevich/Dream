package and.degilevich.dream.shared.feature.artist.component.details.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsUIState
import and.degilevich.dream.shared.feature.artist.component.details.api.design.ArtistDetailsScreen
import and.degilevich.dream.shared.feature.artist.component.details.api.preview.provider.ArtistDetailsUIStatePreviewProvider
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewParameter

@PreviewLightDark
@Composable
private fun ArtistDetailsScreenPreview(
    @PreviewParameter(ArtistDetailsUIStatePreviewProvider::class)
    state: ArtistDetailsUIState
) {
    ComposeAppTheme {
        ArtistDetailsScreen(
            state = state
        ) { }
    }
}