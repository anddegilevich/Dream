package and.degilevich.dream.shared.feature.artist.domain.api.usecase

import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtistAlbums.GetArtistAlbumsParams
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtistAlbums.GetArtistAlbumsResult

interface FetchArtistAlbumsUseCase {
    suspend operator fun invoke(params: GetArtistAlbumsParams): Result<GetArtistAlbumsResult>
}