package and.degilevich.dream.shared.feature.player.data.api.repository

import and.degilevich.dream.shared.feature.player.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedParams
import and.degilevich.dream.shared.feature.player.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedResult

interface PlayerRepository {
    suspend fun getRecentlyPlayed(params: GetRecentlyPlayedParams): Result<GetRecentlyPlayedResult>
}
