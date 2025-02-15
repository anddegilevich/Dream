package and.degilevich.dream.shared.feature.artist.core.api.domain.usecase

import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistData
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsParams
import kotlinx.coroutines.flow.Flow

interface GetArtistsFlowUseCase {
    suspend operator fun invoke(params: GetArtistsParams): Flow<Result<List<ArtistData>>>
}