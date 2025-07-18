package and.degilevich.dream.shared.feature.artist.domain.api.usecase

import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtists.GetArtistsParams
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtists.GetArtistsResult

interface FetchArtistsUseCase {
    suspend operator fun invoke(params: GetArtistsParams): Result<GetArtistsResult>
}