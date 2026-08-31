package and.degilevich.dream.shared.feature.playlist.component.list.impl.component

import and.degilevich.dream.shared.feature.playlist.ui.api.mapper.PlaylistInfoToCardUIDataMapper
import and.degilevich.dream.shared.feature.playlist.ui.api.model.PlaylistCardUIData
import and.degilevich.dream.shared.feature.playlist.component.list.impl.component.model.PlaylistListState
import and.degilevich.dream.shared.feature.playlist.component.list.impl.component.model.PlaylistListUIState
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class PlaylistListUIStateMapper : Mapper<PlaylistListState, PlaylistListUIState>, KoinComponent {

    private val playlistInfoToCardUIDataMapper: PlaylistInfoToCardUIDataMapper by inject()

    override fun map(item: PlaylistListState): PlaylistListUIState = with(item) {
        PlaylistListUIState(
            playlists = mapToPlaylists(state = this)
        )
    }

    private fun mapToPlaylists(state: PlaylistListState): Skeleton<ImmutableList<PlaylistCardUIData>> = with(state) {
        Skeleton.from(
            isLoading = playlists.isNotEmpty()
        ) {
            playlists
                .asSequence()
                .mapWith(playlistInfoToCardUIDataMapper)
                .toImmutableList()
        }
    }
}
