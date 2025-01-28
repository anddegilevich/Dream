package and.degilevich.dream.shared.feature.artist.core.impl.domain.usecase

import and.degilevich.dream.shared.feature.artist.core.api.domain.usecase.GetArtistsFlowUseCase
import and.degilevich.dream.shared.feature.artist.model.core.ArtistData
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsRequest
import and.degilevich.dream.shared.feature.artist.core.api.source.local.ArtistLocalDataSource
import and.degilevich.dream.shared.feature.artist.core.api.source.remote.ArtistRemoteDataSource
import and.degilevich.dream.shared.foundation.primitive.result.foldResultSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class GetArtistsFlowUseCaseImpl(
    private val remoteDataSource: ArtistRemoteDataSource,
    private val localDataSource: ArtistLocalDataSource
) : GetArtistsFlowUseCase {

    override suspend fun invoke(request: GetArtistsRequest): Flow<Result<List<ArtistData>>> {
        return flow {
            emit(
                localDataSource.getArtists(request).foldResultSuccess { response ->
                    response.artists
                }
            )
            emit(
                remoteDataSource.getArtists(request).foldResultSuccess { response ->
                    response.artists
                }
            )
        }
    }
}