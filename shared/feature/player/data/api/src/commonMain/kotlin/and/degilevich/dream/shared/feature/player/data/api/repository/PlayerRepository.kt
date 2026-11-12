package and.degilevich.dream.shared.feature.player.data.api.repository

import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.getPlaybackState.GetPlaybackStateResult
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedParams
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedResult
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.setShuffle.SetShuffleParams

interface PlayerRepository {
    suspend fun getRecentlyPlayed(params: GetRecentlyPlayedParams): Result<GetRecentlyPlayedResult>
    suspend fun getPlaybackState(): Result<GetPlaybackStateResult>
    suspend fun skipToNext(): Result<Unit>
    suspend fun skipToPrevious(): Result<Unit>
    suspend fun setShuffle(params: SetShuffleParams): Result<Unit>
    suspend fun pause(): Result<Unit>
    suspend fun resume(): Result<Unit>
}
