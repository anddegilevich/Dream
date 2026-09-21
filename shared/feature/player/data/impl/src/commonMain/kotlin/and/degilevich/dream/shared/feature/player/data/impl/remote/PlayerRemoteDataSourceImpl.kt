package and.degilevich.dream.shared.feature.player.data.impl.remote

import and.degilevich.dream.shared.core.service.api.ApiService
import and.degilevich.dream.shared.core.service.api.generated.api.PlayerApi
import and.degilevich.dream.shared.feature.player.data.mapper.api.remote.RecentlyPlayedResponseToResultMapper
import and.degilevich.dream.shared.feature.player.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedParams
import and.degilevich.dream.shared.feature.player.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class PlayerRemoteDataSourceImpl(
    private val apiService: ApiService,
    private val recentlyPlayedResponseToResultMapper: RecentlyPlayedResponseToResultMapper
) : PlayerRemoteDataSource {

    private val playerApi: PlayerApi by lazy { apiService.playerApi }

    override suspend fun getRecentlyPlayed(
        params: GetRecentlyPlayedParams
    ): Result<GetRecentlyPlayedResult> = runCatching {
        playerApi.getRecentlyPlayed(limit = params.limit).body()
    }.map { response ->
        response.mapWith(recentlyPlayedResponseToResultMapper)
    }
}
