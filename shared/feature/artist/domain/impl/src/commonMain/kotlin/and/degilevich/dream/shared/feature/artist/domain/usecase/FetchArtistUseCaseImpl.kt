package and.degilevich.dream.shared.feature.artist.domain.usecase

import and.degilevich.dream.shared.feature.artist.domain.api.usecase.FetchArtistUseCase
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtist.GetArtistResult
import and.degilevich.dream.shared.feature.artist.source.api.remote.ArtistRemoteDataSource

internal class FetchArtistUseCaseImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource
) : FetchArtistUseCase {
    override suspend fun invoke(params: GetArtistParams): Result<GetArtistResult> {
        return artistRemoteDataSource.getArtist(params)
    }
}