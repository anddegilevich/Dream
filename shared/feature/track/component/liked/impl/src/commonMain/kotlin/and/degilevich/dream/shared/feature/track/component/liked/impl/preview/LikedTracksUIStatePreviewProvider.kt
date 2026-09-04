package and.degilevich.dream.shared.feature.track.component.liked.impl.preview

import and.degilevich.dream.shared.feature.playlist.ui.api.preview.PlaylistTrackCardUIDataPreviewProvider
import and.degilevich.dream.shared.feature.track.component.liked.impl.component.model.LikedTracksUIState
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider

class LikedTracksUIStatePreviewProvider : LabeledPreviewParameterProvider<LikedTracksUIState>() {

    private val playlistTrackCardUIDataPreviewProvider = PlaylistTrackCardUIDataPreviewProvider()

    override val labeledValues = listOf(
        "Skeleton" to provideSkeleton(),
        "Default" to provideDefault(),
        "Loading next page" to provideLoadingNextPage()
    )

    fun provideSkeleton(): LikedTracksUIState {
        return LikedTracksUIState(
            count = Skeleton.Loading,
            tracks = Skeleton.Loading,
            isLoadingTracks = false
        )
    }

    fun provideDefault(): LikedTracksUIState {
        return LikedTracksUIState(
            count = Skeleton.Value("145 songs"),
            tracks = Skeleton.Value(playlistTrackCardUIDataPreviewProvider.provideList()),
            isLoadingTracks = false
        )
    }

    fun provideLoadingNextPage(): LikedTracksUIState {
        return provideDefault().copy(isLoadingTracks = true)
    }
}
