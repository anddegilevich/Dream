package and.degilevich.dream.shared.feature.track.component.liked.impl.component

import and.degilevich.dream.shared.feature.track.component.liked.impl.component.model.LikedTracksState
import and.degilevich.dream.shared.foundation.decompose.component.mvi.conservator.ComponentStateConservator
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import kotlinx.serialization.KSerializer

internal class LikedTracksStateConservator : ComponentStateConservator<LikedTracksState> {
    override val key: String = LikedTracksState::class.className()
    override val initialState: LikedTracksState = LikedTracksState(
        tracks = emptyList(),
        total = 0,
        isLoadingTracks = false
    )
    override val serializer: KSerializer<LikedTracksState> = LikedTracksState.serializer()
}
