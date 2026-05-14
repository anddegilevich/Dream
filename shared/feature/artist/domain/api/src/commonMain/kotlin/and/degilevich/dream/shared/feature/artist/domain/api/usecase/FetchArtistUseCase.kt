package and.degilevich.dream.shared.feature.artist.domain.api.usecase

import and.degilevich.dream.shared.feature.artist.model.core.method.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtist.GetArtistResult

interface FetchArtistUseCase {
    suspend operator fun invoke(params: GetArtistParams): Result<GetArtistResult>
}