package and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.component.model

import and.degilevich.dream.shared.feature.playlist.ui.api.model.PlaylistTrackCardUIData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList

@Immutable
data class RecentlyPlayedUIState(
    val items: Skeleton<ImmutableList<PlaylistTrackCardUIData>>
) {

    companion object : EmptyFactory<RecentlyPlayedUIState> {

        override fun empty(): RecentlyPlayedUIState {
            return RecentlyPlayedUIState(items = Skeleton.Loading)
        }
    }
}
