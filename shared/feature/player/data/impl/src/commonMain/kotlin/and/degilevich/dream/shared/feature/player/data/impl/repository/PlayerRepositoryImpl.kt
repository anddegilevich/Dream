package and.degilevich.dream.shared.feature.player.data.impl.repository

import and.degilevich.dream.shared.feature.player.data.api.repository.PlayerRepository
import and.degilevich.dream.shared.feature.player.data.impl.remote.PlayerRemoteDataSource
import and.degilevich.dream.shared.feature.player.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedParams
import and.degilevich.dream.shared.feature.player.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedResult

internal class PlayerRepositoryImpl(
    private val playerRemoteDataSource: PlayerRemoteDataSource
) : PlayerRepository {

    override suspend fun getRecentlyPlayed(
        params: GetRecentlyPlayedParams
    ): Result<GetRecentlyPlayedResult> {
        return playerRemoteDataSource.getRecentlyPlayed(params = params)
    }
}
