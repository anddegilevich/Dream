package and.degilevich.dream.shared.feature.player.data.impl.remote

import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.getPlaybackState.GetPlaybackStateResult
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedParams
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedResult
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.setShuffle.SetShuffleParams
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakePlayerRemoteDataSource(
    private val onGetRecentlyPlayed: (GetRecentlyPlayedParams) -> Result<GetRecentlyPlayedResult> = {
        fakeImplementationError()
    },
    private val onGetPlaybackState: () -> Result<GetPlaybackStateResult> = { fakeImplementationError() },
    private val onSkipToNext: () -> Result<Unit> = { fakeImplementationError() },
    private val onSkipToPrevious: () -> Result<Unit> = { fakeImplementationError() },
    private val onSetShuffle: (SetShuffleParams) -> Result<Unit> = { fakeImplementationError() }
) : PlayerRemoteDataSource {

    override suspend fun getRecentlyPlayed(
        params: GetRecentlyPlayedParams
    ): Result<GetRecentlyPlayedResult> = onGetRecentlyPlayed(params)

    override suspend fun getPlaybackState(): Result<GetPlaybackStateResult> = onGetPlaybackState()

    override suspend fun skipToNext(): Result<Unit> = onSkipToNext()

    override suspend fun skipToPrevious(): Result<Unit> = onSkipToPrevious()

    override suspend fun setShuffle(params: SetShuffleParams): Result<Unit> = onSetShuffle(params)
}
