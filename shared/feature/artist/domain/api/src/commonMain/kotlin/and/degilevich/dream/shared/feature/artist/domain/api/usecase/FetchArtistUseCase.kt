package and.degilevich.dream.shared.feature.artist.domain.api.usecase

import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtist.GetArtistResult

interface FetchArtistUseCase {
    suspend operator fun invoke(params: GetArtistParams): Result<GetArtistResult>
}