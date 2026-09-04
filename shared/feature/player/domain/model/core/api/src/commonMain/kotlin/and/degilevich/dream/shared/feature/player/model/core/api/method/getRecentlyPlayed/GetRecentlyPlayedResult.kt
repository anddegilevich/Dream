package and.degilevich.dream.shared.feature.player.model.core.api.method.getRecentlyPlayed

import and.degilevich.dream.shared.feature.player.model.core.api.data.PlayHistoryData

data class GetRecentlyPlayedResult(
    val items: List<PlayHistoryData>
)
