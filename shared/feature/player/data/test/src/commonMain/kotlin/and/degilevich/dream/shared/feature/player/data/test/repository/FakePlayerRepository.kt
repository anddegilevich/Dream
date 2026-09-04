package and.degilevich.dream.shared.feature.player.data.test.repository

import and.degilevich.dream.shared.feature.player.data.api.repository.PlayerRepository
import and.degilevich.dream.shared.feature.player.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedParams
import and.degilevich.dream.shared.feature.player.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedResult
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakePlayerRepository(
    private val onGetRecentlyPlayed: (GetRecentlyPlayedParams) -> Result<GetRecentlyPlayedResult> = {
        fakeImplementationError()
    }
) : PlayerRepository {

    override suspend fun getRecentlyPlayed(
        params: GetRecentlyPlayedParams
    ): Result<GetRecentlyPlayedResult> = onGetRecentlyPlayed(params)
}
