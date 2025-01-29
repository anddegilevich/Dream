package and.degilevich.dream.shared.feature.artist.core.impl.domain.usecase

import and.degilevich.dream.shared.feature.artist.core.api.domain.usecase.GetArtistFlowUseCase
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtist.GetArtistRequest
import and.degilevich.dream.shared.feature.artist.core.api.source.remote.ArtistRemoteDataSource
import and.degilevich.dream.shared.feature.artist.model.core.ArtistData
import and.degilevich.dream.shared.foundation.primitive.result.foldResultSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class GetArtistFlowUseCaseImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistRemoteDataSource
) : GetArtistFlowUseCase {
    override suspend fun invoke(request: GetArtistRequest): Flow<Result<ArtistData>> {
        return flow {
            emit(
                artistLocalDataSource.getArtist(request).foldResultSuccess { response ->
                    response.artist
                }
            )
            emit(
                artistRemoteDataSource.getArtist(request).foldResultSuccess { response ->
                    response.artist
                }
            )
        }
    }
}