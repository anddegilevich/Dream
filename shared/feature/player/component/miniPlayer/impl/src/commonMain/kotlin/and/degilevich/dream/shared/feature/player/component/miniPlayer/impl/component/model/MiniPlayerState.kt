package and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.component.model

import and.degilevich.dream.shared.feature.player.domain.model.core.api.data.PlaybackStateData
import kotlinx.serialization.Serializable

@Serializable
data class MiniPlayerState(
    val playbackState: PlaybackStateData
)
