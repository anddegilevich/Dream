package and.degilevich.dream.shared.feature.artist.core.impl.logic.usecase

import and.degilevich.dream.shared.feature.artist.core.api.logic.usecase.GetArtistFlowUseCase
import and.degilevich.dream.shared.feature.artist.core.api.source.local.ArtistLocalDataSource
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.core.api.source.remote.ArtistRemoteDataSource
import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistData
import and.degilevich.dream.shared.foundation.primitive.result.foldResultSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class GetArtistFlowUseCaseImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource
) : GetArtistFlowUseCase {
    override suspend fun invoke(params: GetArtistParams): Flow<Result<ArtistData>> {
        return flow {
            emit(
                artistLocalDataSource.getArtist(id = params.id).foldResultSuccess { artist ->
                    artist
                }
            )
            emit(
                artistRemoteDataSource.getArtist(params)
                    .onSuccess { response ->
                        artistLocalDataSource.saveArtist(artist = response.artist)
                    }
                    .foldResultSuccess { response ->
                        response.artist
                    }
            )
        }
    }
}