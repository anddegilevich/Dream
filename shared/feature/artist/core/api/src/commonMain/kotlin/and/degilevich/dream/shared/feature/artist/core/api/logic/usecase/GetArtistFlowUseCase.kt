package and.degilevich.dream.shared.feature.artist.core.api.logic.usecase

import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import kotlinx.coroutines.flow.Flow

interface GetArtistFlowUseCase {
    suspend operator fun invoke(params: GetArtistParams): Flow<Result<ArtistData>>
}