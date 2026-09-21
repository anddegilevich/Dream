package and.degilevich.dream.shared.feature.player.data.impl.remote

import and.degilevich.dream.shared.feature.player.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedParams
import and.degilevich.dream.shared.feature.player.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedResult

internal interface PlayerRemoteDataSource {
    suspend fun getRecentlyPlayed(params: GetRecentlyPlayedParams): Result<GetRecentlyPlayedResult>
}
