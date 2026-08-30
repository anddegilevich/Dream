package and.degilevich.dream.shared.feature.playlist.component.list.impl.component.model

import and.degilevich.dream.shared.feature.playlist.ui.api.model.PlaylistCardUIData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList

@Immutable
data class PlaylistListUIState(
    val playlists: Skeleton<ImmutableList<PlaylistCardUIData>>
) {

    companion object : EmptyFactory<PlaylistListUIState> {

        override fun empty(): PlaylistListUIState {
            return PlaylistListUIState(
                playlists = Skeleton.Loading
            )
        }
    }
}
