package and.degilevich.dream.shared.feature.artist.core.impl.domain.usecase

import and.degilevich.dream.shared.feature.artist.core.api.domain.usecase.GetArtistsFlowUseCase
import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistData
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsParams
import and.degilevich.dream.shared.feature.artist.core.api.source.remote.ArtistRemoteDataSource
import and.degilevich.dream.shared.foundation.primitive.result.foldResultSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class GetArtistsFlowUseCaseImpl(
    private val remoteDataSource: ArtistRemoteDataSource,
//    private val localDataSource: ArtistLocalDataSource
) : GetArtistsFlowUseCase {

    //FIXME: Save response to db
    override suspend fun invoke(params: GetArtistsParams): Flow<Result<List<ArtistData>>> {
        return flow {
//            emit(
//                localDataSource.getArtists(params).foldResultSuccess { response ->
//                    response.artists
//                }
//            )
            emit(
                remoteDataSource.getArtists(params).foldResultSuccess { response ->
                    response.artists
                }
            )
        }
    }
}