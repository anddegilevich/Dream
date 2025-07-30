package and.degilevich.dream.shared.feature.artist.domain.api.usecase

import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistRelatedArtists.GetArtistRelatedArtistsParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistRelatedArtists.GetArtistRelatedArtistsResult

interface FetchArtistRelatedArtistsUseCase {
    suspend operator fun invoke(params: GetArtistRelatedArtistsParams): Result<GetArtistRelatedArtistsResult>
}