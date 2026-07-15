package and.degilevich.dream.shared.feature.album.component.details.impl.component.model

import and.degilevich.dream.shared.feature.artist.ui.api.model.ArtistLabelUIData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import and.degilevich.dream.shated.feature.track.ui.api.model.TrackCardUIData
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList

@Immutable
data class AlbumDetailsUIState(
    val info: Skeleton<AlbumDetailsLayoutUIData>,
    val artists: Skeleton<ImmutableList<ArtistLabelUIData>>,
    val tracks: Skeleton<ImmutableList<TrackCardUIData>>
) {
    companion object : EmptyFactory<AlbumDetailsUIState> {
        override fun empty(): AlbumDetailsUIState {
            return AlbumDetailsUIState(
                info = Skeleton.Loading,
                artists = Skeleton.Loading,
                tracks = Skeleton.Loading
            )
        }
    }
}