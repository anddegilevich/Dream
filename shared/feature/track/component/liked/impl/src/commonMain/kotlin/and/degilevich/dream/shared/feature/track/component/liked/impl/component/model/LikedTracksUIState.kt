package and.degilevich.dream.shared.feature.track.component.liked.impl.component.model

import and.degilevich.dream.shared.feature.playlist.ui.api.model.PlaylistTrackCardUIData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList

@Immutable
data class LikedTracksUIState(
    val count: Skeleton<String>,
    val tracks: Skeleton<ImmutableList<PlaylistTrackCardUIData>>,
    val isLoadingTracks: Boolean
) {

    companion object : EmptyFactory<LikedTracksUIState> {

        override fun empty(): LikedTracksUIState {
            return LikedTracksUIState(
                count = Skeleton.Loading,
                tracks = Skeleton.Loading,
                isLoadingTracks = false
            )
        }
    }
}
