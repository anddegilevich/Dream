package and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.component

import and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.component.model.RecentlyPlayedState
import and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.component.model.RecentlyPlayedUIState
import and.degilevich.dream.shared.feature.playlist.ui.api.mapper.TrackDataToPlaylistTrackCardUIDataMapper
import and.degilevich.dream.shared.feature.playlist.ui.api.model.PlaylistTrackCardUIData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class RecentlyPlayedUIStateMapper : Mapper<RecentlyPlayedState, RecentlyPlayedUIState>, KoinComponent {

    private val trackDataToPlaylistTrackCardUIDataMapper: TrackDataToPlaylistTrackCardUIDataMapper by inject()

    override fun map(item: RecentlyPlayedState): RecentlyPlayedUIState = with(item) {
        RecentlyPlayedUIState(
            items = mapToItems(state = this)
        )
    }

    private fun mapToItems(
        state: RecentlyPlayedState
    ): Skeleton<ImmutableList<PlaylistTrackCardUIData>> = with(state) {
        Skeleton.from(
            isLoading = items.isEmpty()
        ) {
            items
                .mapIndexed { index, playHistory ->
                    trackDataToPlaylistTrackCardUIDataMapper
                        .map(playHistory.track)
                        .copy(number = (index + 1).toString())
                }
                .toImmutableList()
        }
    }
}
