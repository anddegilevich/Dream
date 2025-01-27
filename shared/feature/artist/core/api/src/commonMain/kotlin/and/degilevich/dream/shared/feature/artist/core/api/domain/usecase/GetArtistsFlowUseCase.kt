package and.degilevich.dream.shared.feature.artist.core.api.domain.usecase

import and.degilevich.dream.shared.feature.artist.core.api.model.ArtistData
import and.degilevich.dream.shared.feature.artist.core.api.model.request.getArtists.GetArtistsRequest
import kotlinx.coroutines.flow.Flow

interface GetArtistsFlowUseCase {
    suspend operator fun invoke(request: GetArtistsRequest): Flow<Result<List<ArtistData>>>
}