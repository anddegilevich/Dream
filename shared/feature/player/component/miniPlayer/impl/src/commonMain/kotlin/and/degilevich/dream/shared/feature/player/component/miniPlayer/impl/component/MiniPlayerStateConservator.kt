package and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.component

import and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.component.model.MiniPlayerState
import and.degilevich.dream.shared.feature.player.domain.model.core.api.data.PlaybackStateData
import and.degilevich.dream.shared.foundation.decompose.component.mvi.conservator.ComponentStateConservator
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import kotlinx.serialization.KSerializer

internal class MiniPlayerStateConservator : ComponentStateConservator<MiniPlayerState> {
    override val key: String = MiniPlayerState::class.className()
    override val initialState: MiniPlayerState = MiniPlayerState(
        playbackState = PlaybackStateData.empty()
    )
    override val serializer: KSerializer<MiniPlayerState> = MiniPlayerState.serializer()
}
