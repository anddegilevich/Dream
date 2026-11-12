package and.degilevich.dream.shared.feature.player.data.impl.repository

import and.degilevich.dream.shared.feature.player.data.api.repository.PlayerRepository
import and.degilevich.dream.shared.feature.player.data.impl.remote.PlayerRemoteDataSource
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.getPlaybackState.GetPlaybackStateResult
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedParams
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedResult
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.setShuffle.SetShuffleParams

internal class PlayerRepositoryImpl(
    private val playerRemoteDataSource: PlayerRemoteDataSource
) : PlayerRepository {

    override suspend fun getRecentlyPlayed(
        params: GetRecentlyPlayedParams
    ): Result<GetRecentlyPlayedResult> {
        return playerRemoteDataSource.getRecentlyPlayed(params = params)
    }

    override suspend fun getPlaybackState(): Result<GetPlaybackStateResult> {
        return playerRemoteDataSource.getPlaybackState()
    }

    override suspend fun skipToNext(): Result<Unit> {
        return playerRemoteDataSource.skipToNext()
    }

    override suspend fun skipToPrevious(): Result<Unit> {
        return playerRemoteDataSource.skipToPrevious()
    }

    override suspend fun setShuffle(params: SetShuffleParams): Result<Unit> {
        return playerRemoteDataSource.setShuffle(params = params)
    }

    override suspend fun pause(): Result<Unit> {
        return playerRemoteDataSource.pause()
    }

    override suspend fun resume(): Result<Unit> {
        return playerRemoteDataSource.resume()
    }
}
