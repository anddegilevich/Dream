package and.degilevich.dream.shared.feature.album.component.details.api.preview.provider

import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsUIState
import and.degilevich.dream.shared.feature.artist.design.api.preview.provider.ArtistLabelUIDataPreviewProvider
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import and.degilevich.dream.shated.feature.track.design.api.preview.provider.TrackCardUIDataPreviewProvider
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class AlbumDetailsUIStatePreviewProvider : PreviewParameterProvider<AlbumDetailsUIState> {

    override val values: Sequence<AlbumDetailsUIState> = sequenceOf(
        provideSkeleton(),
        provide()
    )

    fun provideSkeleton(): AlbumDetailsUIState {
        return AlbumDetailsUIState.empty()
    }

    fun provide(): AlbumDetailsUIState {
        return AlbumDetailsUIState(
            info = Skeleton.Value(AlbumDetailsLayoutUIDataPreviewProvider().provide()),
            artists = Skeleton.Value(ArtistLabelUIDataPreviewProvider().provideList()),
            tracks = Skeleton.Value(TrackCardUIDataPreviewProvider().provideList())
        )
    }
}