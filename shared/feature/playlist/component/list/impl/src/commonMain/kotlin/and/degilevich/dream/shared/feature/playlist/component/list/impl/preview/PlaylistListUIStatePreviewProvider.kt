package and.degilevich.dream.shared.feature.playlist.component.list.impl.preview

import and.degilevich.dream.shared.feature.playlist.ui.api.preview.PlaylistCardUIDataPreviewProvider
import and.degilevich.dream.shared.feature.playlist.component.list.impl.component.model.PlaylistListUIState
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider

class PlaylistListUIStatePreviewProvider : LabeledPreviewParameterProvider<PlaylistListUIState>() {

    private val playlistCardUIDataPreviewProvider = PlaylistCardUIDataPreviewProvider()

    override val labeledValues = listOf(
        "Skeleton" to provideSkeleton(),
        "Default" to provideDefault()
    )

    fun provideSkeleton(): PlaylistListUIState {
        return PlaylistListUIState.empty()
    }

    fun provideDefault(): PlaylistListUIState {
        return PlaylistListUIState(
            playlists = Skeleton.Value(playlistCardUIDataPreviewProvider.provideList())
        )
    }
}
