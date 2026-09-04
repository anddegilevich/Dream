package and.degilevich.dream.shared.feature.player.data.impl.remote

import and.degilevich.dream.shared.feature.player.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedParams
import and.degilevich.dream.shared.feature.player.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedResult
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakePlayerRemoteDataSource(
    private val onGetRecentlyPlayed: (GetRecentlyPlayedParams) -> Result<GetRecentlyPlayedResult> = {
        fakeImplementationError()
    }
) : PlayerRemoteDataSource {

    override suspend fun getRecentlyPlayed(
        params: GetRecentlyPlayedParams
    ): Result<GetRecentlyPlayedResult> = onGetRecentlyPlayed(params)
}
