package and.degilevich.dream.shared.feature.artist.core.impl.logic.usecase

import and.degilevich.dream.shared.feature.artist.core.api.logic.usecase.GetArtistsFlowUseCase
import and.degilevich.dream.shared.feature.artist.core.api.source.local.ArtistLocalDataSource
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsParams
import and.degilevich.dream.shared.feature.artist.core.api.source.remote.ArtistRemoteDataSource
import and.degilevich.dream.shared.foundation.primitive.result.foldResultSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class GetArtistsFlowUseCaseImpl(
    private val remoteDataSource: ArtistRemoteDataSource,
    private val localDataSource: ArtistLocalDataSource
) : GetArtistsFlowUseCase {

    override suspend fun invoke(params: GetArtistsParams): Flow<Result<List<ArtistData>>> {
        return flow {
            emit(
                Result.success(localDataSource.getArtists(params))
            )
            emit(
                remoteDataSource.getArtists(params)
                    .onSuccess { response ->
                        localDataSource.saveArtists(artists = response.artists)
                    }
                    .foldResultSuccess { response ->
                        response.artists
                    }
            )
        }
    }
}