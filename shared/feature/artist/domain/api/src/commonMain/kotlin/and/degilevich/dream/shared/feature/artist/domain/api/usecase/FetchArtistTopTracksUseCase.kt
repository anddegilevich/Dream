package and.degilevich.dream.shared.feature.artist.domain.api.usecase

import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtistTopTracks.GetArtistTopTracksParams
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtistTopTracks.GetArtistTopTracksResult

interface FetchArtistTopTracksUseCase {
    suspend operator fun invoke(params: GetArtistTopTracksParams): Result<GetArtistTopTracksResult>
}