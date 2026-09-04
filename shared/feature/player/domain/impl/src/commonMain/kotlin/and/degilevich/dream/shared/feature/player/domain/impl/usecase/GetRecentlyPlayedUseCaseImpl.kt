package and.degilevich.dream.shared.feature.player.domain.impl.usecase

import and.degilevich.dream.shared.feature.player.data.api.repository.PlayerRepository
import and.degilevich.dream.shared.feature.player.domain.api.usecase.GetRecentlyPlayedUseCase
import and.degilevich.dream.shared.feature.player.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedParams
import and.degilevich.dream.shared.feature.player.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedResult

internal class GetRecentlyPlayedUseCaseImpl(
    private val playerRepository: PlayerRepository
) : GetRecentlyPlayedUseCase {

    override suspend fun invoke(params: GetRecentlyPlayedParams): Result<GetRecentlyPlayedResult> {
        return playerRepository.getRecentlyPlayed(params = params)
    }
}
