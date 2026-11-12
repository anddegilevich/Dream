package and.degilevich.dream.shared.feature.player.component.player.impl.component

import and.degilevich.dream.shared.feature.player.component.player.impl.component.model.PlayerState
import and.degilevich.dream.shared.feature.player.domain.model.core.api.data.PlaybackStateData
import and.degilevich.dream.shared.foundation.decompose.component.mvi.conservator.ComponentStateConservator
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import kotlinx.serialization.KSerializer

internal class PlayerStateConservator : ComponentStateConservator<PlayerState> {
    override val key: String = PlayerState::class.className()
    override val initialState: PlayerState = PlayerState(
        playbackState = PlaybackStateData.empty()
    )
    override val serializer: KSerializer<PlayerState> = PlayerState.serializer()
}
