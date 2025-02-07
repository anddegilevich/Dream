package and.degilevich.dream.shared.feature.artist.core.impl.domain.usecase

import and.degilevich.dream.shared.feature.artist.core.api.domain.usecase.GetArtistFlowUseCase
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.core.api.source.remote.ArtistRemoteDataSource
import and.degilevich.dream.shared.feature.artist.model.core.ArtistData
import and.degilevich.dream.shared.foundation.primitive.result.foldResultSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

//FIXME: Cache remote results to local data source
internal class GetArtistFlowUseCaseImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
//    private val artistLocalDataSource: ArtistLocalDataSource
) : GetArtistFlowUseCase {
    override suspend fun invoke(params: GetArtistParams): Flow<Result<ArtistData>> {
        return flow {
//            emit(
//                artistLocalDataSource.getArtist(params).foldResultSuccess { response ->
//                    response.artist
//                }
//            )
            emit(
                artistRemoteDataSource.getArtist(params).foldResultSuccess { response ->
                    response.artist
                }
            )
        }
    }
}