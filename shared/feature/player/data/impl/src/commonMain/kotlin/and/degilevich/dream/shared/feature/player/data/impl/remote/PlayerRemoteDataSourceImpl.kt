package and.degilevich.dream.shared.feature.player.data.impl.remote

import and.degilevich.dream.shared.core.service.api.ApiService
import and.degilevich.dream.shared.core.service.api.generated.api.PlayerApi
import and.degilevich.dream.shared.feature.player.data.mapper.api.remote.PlaybackStateResponseToResultMapper
import and.degilevich.dream.shared.feature.player.data.mapper.api.remote.RecentlyPlayedResponseToResultMapper
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.getPlaybackState.GetPlaybackStateResult
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedParams
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedResult
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.setShuffle.SetShuffleParams
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.result.foldResult

internal class PlayerRemoteDataSourceImpl(
    private val apiService: ApiService,
    private val recentlyPlayedResponseToResultMapper: RecentlyPlayedResponseToResultMapper,
    private val playbackStateResponseToResultMapper: PlaybackStateResponseToResultMapper
) : PlayerRemoteDataSource {

    private val playerApi: PlayerApi by lazy { apiService.playerApi }

    override suspend fun getRecentlyPlayed(
        params: GetRecentlyPlayedParams
    ): Result<GetRecentlyPlayedResult> = runCatching {
        playerApi.getRecentlyPlayed(limit = params.limit).body()
    }.map { response ->
        response.mapWith(recentlyPlayedResponseToResultMapper)
    }

    override suspend fun getPlaybackState(): Result<GetPlaybackStateResult> = runCatching {
        playerApi.getInformationAboutTheUsersCurrentPlayback()
    }.foldResult { response ->
        if (response.status == STATUS_NO_CONTENT) {
            Result.success(GetPlaybackStateResult.None)
        } else {
            runCatching { response.body() }.map { body ->
                body.mapWith(playbackStateResponseToResultMapper)
            }
        }
    }

    override suspend fun skipToNext(): Result<Unit> = runCatching {
        playerApi.skipUsersPlaybackToNextTrack()
    }.map { }

    override suspend fun skipToPrevious(): Result<Unit> = runCatching {
        playerApi.skipUsersPlaybackToPreviousTrack()
    }.map { }

    override suspend fun setShuffle(params: SetShuffleParams): Result<Unit> = runCatching {
        playerApi.toggleShuffleForUsersPlayback(state = params.isEnabled)
    }.map { }

    private companion object {
        const val STATUS_NO_CONTENT = 204
    }
}
