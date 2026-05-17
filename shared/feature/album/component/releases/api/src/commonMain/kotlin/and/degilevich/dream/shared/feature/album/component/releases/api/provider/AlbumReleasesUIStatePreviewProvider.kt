package and.degilevich.dream.shared.feature.album.component.releases.api.provider

import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesUIState
import and.degilevich.dream.shared.feature.album.ui.api.provider.AlbumCardUIDataPreviewProvider
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider

class AlbumReleasesUIStatePreviewProvider : LabeledPreviewParameterProvider<AlbumReleasesUIState>() {

    override val labeledValues = listOf(
        "Skeleton" to provideSkeleton(),
        "Default" to provideDefault()
    )

    fun provideSkeleton(): AlbumReleasesUIState {
        return AlbumReleasesUIState.empty()
    }

    fun provideDefault(): AlbumReleasesUIState {
        return AlbumReleasesUIState(
            releases = Skeleton.Value(AlbumCardUIDataPreviewProvider().provideList())
        )
    }
}