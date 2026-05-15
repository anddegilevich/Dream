package and.degilevich.dream.shared.feature.album.component.details.api.provider

import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsUIState
import and.degilevich.dream.shared.feature.artist.ui.api.provider.ArtistLabelUIDataPreviewProvider
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider
import and.degilevich.dream.shated.feature.track.ui.api.provider.TrackCardUIDataPreviewProvider

class AlbumDetailsUIStatePreviewProvider : LabeledPreviewParameterProvider<AlbumDetailsUIState>() {

    override val labeledValues = listOf(
        "Skeleton" to provideSkeleton(),
        "Default" to provideDefault()
    )

    fun provideSkeleton(): AlbumDetailsUIState {
        return AlbumDetailsUIState.empty()
    }

    fun provideDefault(): AlbumDetailsUIState {
        return AlbumDetailsUIState(
            info = Skeleton.Value(AlbumDetailsLayoutUIDataPreviewProvider().provideDefault()),
            artists = Skeleton.Value(ArtistLabelUIDataPreviewProvider().provideList()),
            tracks = Skeleton.Value(TrackCardUIDataPreviewProvider().provideList())
        )
    }
}