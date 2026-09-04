package and.degilevich.dream.shared.feature.player.domain.api.usecase

import and.degilevich.dream.shared.feature.player.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedParams
import and.degilevich.dream.shared.feature.player.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedResult

interface GetRecentlyPlayedUseCase {
    suspend operator fun invoke(params: GetRecentlyPlayedParams): Result<GetRecentlyPlayedResult>
}
