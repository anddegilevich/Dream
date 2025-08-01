package and.degilevich.dream.shared.feature.artist.component.details.api.component.model

import and.degilevich.dream.shared.feature.album.design.api.model.AlbumCardUIData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import and.degilevich.dream.shated.feature.track.design.api.model.TrackCardUIData
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList

@Immutable
data class ArtistDetailsUIState(
    val info: Skeleton<ArtistInfoCardUIData>,
    val topTracks: Skeleton<ImmutableList<TrackCardUIData>>,
    val albums: Skeleton<ImmutableList<AlbumCardUIData>>
) {
    companion object : EmptyFactory<ArtistDetailsUIState> {
        override fun empty(): ArtistDetailsUIState {
            return ArtistDetailsUIState(
                info = Skeleton.Loading,
                topTracks = Skeleton.Loading,
                albums = Skeleton.Loading
            )
        }
    }
}
