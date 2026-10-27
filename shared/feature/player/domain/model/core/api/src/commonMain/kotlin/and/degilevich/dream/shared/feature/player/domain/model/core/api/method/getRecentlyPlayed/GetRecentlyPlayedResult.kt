package and.degilevich.dream.shared.feature.player.domain.model.core.api.method.getRecentlyPlayed

import and.degilevich.dream.shared.feature.player.domain.model.core.api.data.PlayHistoryData

data class GetRecentlyPlayedResult(
    val items: List<PlayHistoryData>
)
