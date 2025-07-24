package and.degilevich.dream.shared.feature.album.component.releases.api.preview.provider

import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesUIState
import and.degilevich.dream.shared.feature.album.design.api.preview.provider.AlbumCardUIDataPreviewProvider

@Suppress("MagicNumber")
object AlbumReleasesUIStatePreviewProvider {

    fun provide(): AlbumReleasesUIState {
        return AlbumReleasesUIState(
            isLoading = false,
            releases = AlbumCardUIDataPreviewProvider.provideList()
        )
    }
}