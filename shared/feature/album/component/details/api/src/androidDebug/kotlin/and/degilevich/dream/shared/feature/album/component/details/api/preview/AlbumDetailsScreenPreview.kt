package and.degilevich.dream.shared.feature.album.component.details.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsUIState
import and.degilevich.dream.shared.feature.album.component.details.api.design.AlbumDetailsScreen
import and.degilevich.dream.shared.feature.album.component.details.api.preview.provider.AlbumDetailsUIStatePreviewProvider
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewParameter

@PreviewLightDark
@Composable
private fun AlbumDetailsScreenPreview(
    @PreviewParameter(AlbumDetailsUIStatePreviewProvider::class)
    state: AlbumDetailsUIState
) {
    ComposeAppTheme {
        AlbumDetailsScreen(
            state = state
        ) { }
    }
}