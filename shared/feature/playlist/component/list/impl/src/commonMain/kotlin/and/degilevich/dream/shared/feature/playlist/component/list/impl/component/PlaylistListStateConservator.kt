package and.degilevich.dream.shared.feature.playlist.component.list.impl.component

import and.degilevich.dream.shared.feature.playlist.component.list.impl.component.model.PlaylistListState
import and.degilevich.dream.shared.foundation.decompose.component.mvi.conservator.ComponentStateConservator
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import kotlinx.serialization.KSerializer

internal class PlaylistListStateConservator : ComponentStateConservator<PlaylistListState> {
    override val key: String = PlaylistListState::class.className()
    override val initialState: PlaylistListState = PlaylistListState(
        isLoading = false,
        playlists = emptyList()
    )
    override val serializer: KSerializer<PlaylistListState> = PlaylistListState.serializer()
}
