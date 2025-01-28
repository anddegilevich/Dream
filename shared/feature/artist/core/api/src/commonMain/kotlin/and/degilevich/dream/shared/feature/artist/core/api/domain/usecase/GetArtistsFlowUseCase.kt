package and.degilevich.dream.shared.feature.artist.core.api.domain.usecase

import and.degilevich.dream.shared.feature.artist.model.core.ArtistData
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsRequest
import kotlinx.coroutines.flow.Flow

interface GetArtistsFlowUseCase {
    suspend operator fun invoke(request: GetArtistsRequest): Flow<Result<List<ArtistData>>>
}