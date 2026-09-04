package and.degilevich.dream.shared.feature.playlist.component.details.impl.component

import and.degilevich.dream.shared.feature.playlist.component.details.impl.component.model.PlaylistDetailsState
import and.degilevich.dream.shared.feature.playlist.model.core.api.data.PlaylistData
import and.degilevich.dream.shared.foundation.decompose.component.mvi.conservator.ComponentStateConservator
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import and.degilevich.dream.shared.navigation.api.model.args.PlaylistDetailsNavArgs
import kotlinx.serialization.KSerializer

internal class PlaylistDetailsStateConservator(
    navArgs: PlaylistDetailsNavArgs
) : ComponentStateConservator<PlaylistDetailsState> {
    override val key: String = PlaylistDetailsState::class.className()
    override val initialState: PlaylistDetailsState = PlaylistDetailsState(
        navArgs = navArgs,
        playlist = PlaylistData.empty(),
        tracks = emptyList(),
        total = 0,
        isLoadingTracks = false
    )
    override val serializer: KSerializer<PlaylistDetailsState> = PlaylistDetailsState.serializer()
}
