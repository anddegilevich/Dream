package and.degilevich.dream.shared.feature.album.component.details.api.component.model

import and.degilevich.dream.shared.feature.artist.design.api.model.ArtistLabelUIData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import and.degilevich.dream.shated.feature.track.design.api.model.TrackCardUIData
import kotlinx.collections.immutable.ImmutableList
import kotlinx.serialization.Serializable

@Serializable
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