package and.degilevich.dream.shared.feature.album.component.releases.api.preview.provider

import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesUIState
import and.degilevich.dream.shared.feature.album.design.api.preview.provider.AlbumCardUIDataPreviewProvider
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class AlbumReleasesUIStatePreviewProvider : PreviewParameterProvider<AlbumReleasesUIState> {

    override val values: Sequence<AlbumReleasesUIState> = sequenceOf(
        provideSkeleton(),
        provide()
    )

    fun provideSkeleton(): AlbumReleasesUIState {
        return AlbumReleasesUIState.empty()
    }

    fun provide(): AlbumReleasesUIState {
        return AlbumReleasesUIState(
            releases = Skeleton.Value(AlbumCardUIDataPreviewProvider().provideList())
        )
    }
}