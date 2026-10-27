package and.degilevich.dream.shared.feature.player.domain.model.core.api.data

import kotlinx.serialization.Serializable

@Serializable
sealed interface PlayerStateData {

    @Serializable
    data object Idle : PlayerStateData

    @Serializable
    data class Active(
        val playbackState: PlaybackStateData
    ) : PlayerStateData
}
