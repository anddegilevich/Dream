package and.degilevich.dream.shared.feature.album.component.releases.api.preview.provider

import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesUIState
import and.degilevich.dream.shared.feature.album.design.api.preview.provider.AlbumCardUIDataPreviewProvider
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton

object AlbumReleasesUIStatePreviewProvider {

    fun provide(): AlbumReleasesUIState {
        return AlbumReleasesUIState(
            releases = Skeleton.Value(AlbumCardUIDataPreviewProvider.provideList())
        )
    }

    fun provideSkeleton(): AlbumReleasesUIState {
        return AlbumReleasesUIState.empty()
    }
}