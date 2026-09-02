package and.degilevich.dream.shared.feature.playlist.component.details.impl.preview

import and.degilevich.dream.shared.feature.playlist.component.details.impl.component.model.PlaylistDetailsUIState
import and.degilevich.dream.shared.feature.playlist.ui.api.preview.PlaylistTrackCardUIDataPreviewProvider
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider

class PlaylistDetailsUIStatePreviewProvider : LabeledPreviewParameterProvider<PlaylistDetailsUIState>() {

    private val playlistTrackCardUIDataPreviewProvider = PlaylistTrackCardUIDataPreviewProvider()
    private val playlistDetailsHeaderUIDataPreviewProvider = PlaylistDetailsHeaderUIDataPreviewProvider()

    override val labeledValues = listOf(
        "Skeleton" to provideSkeleton(),
        "Default" to provideDefault(),
        "Without description" to provideWithoutDescription(),
        "Loading next page" to provideLoadingNextPage()
    )

    fun provideSkeleton(): PlaylistDetailsUIState {
        return PlaylistDetailsUIState(
            header = Skeleton.Loading,
            count = Skeleton.Loading,
            tracks = Skeleton.Loading,
            isLoadingTracks = false
        )
    }

    fun provideDefault(): PlaylistDetailsUIState {
        return PlaylistDetailsUIState(
            header = Skeleton.Value(playlistDetailsHeaderUIDataPreviewProvider.provideDefault()),
            count = Skeleton.Value("145 songs"),
            tracks = Skeleton.Value(playlistTrackCardUIDataPreviewProvider.provideList()),
            isLoadingTracks = false
        )
    }

    fun provideWithoutDescription(): PlaylistDetailsUIState {
        return provideDefault().copy(
            header = Skeleton.Value(playlistDetailsHeaderUIDataPreviewProvider.provideWithoutDescription())
        )
    }

    fun provideLoadingNextPage(): PlaylistDetailsUIState {
        return provideDefault().copy(isLoadingTracks = true)
    }
}
