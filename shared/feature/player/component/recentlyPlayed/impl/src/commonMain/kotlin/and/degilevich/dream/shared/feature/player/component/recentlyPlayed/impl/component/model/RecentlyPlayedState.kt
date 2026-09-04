package and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.component.model

import and.degilevich.dream.shared.feature.player.model.core.api.data.PlayHistoryData
import kotlinx.serialization.Serializable

@Serializable
data class RecentlyPlayedState(
    val isLoading: Boolean,
    val items: List<PlayHistoryData>
)
