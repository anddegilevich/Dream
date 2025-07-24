package and.degilevich.dream.shared.feature.artist.domain.usecase

import and.degilevich.dream.shared.feature.artist.domain.api.usecase.FetchArtistAlbumsUseCase
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtistAlbums.GetArtistAlbumsParams
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtistAlbums.GetArtistAlbumsResult
import and.degilevich.dream.shared.feature.artist.source.api.remote.ArtistRemoteDataSource

internal class FetchArtistAlbumsUseCaseImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource
) : FetchArtistAlbumsUseCase {
    override suspend fun invoke(params: GetArtistAlbumsParams): Result<GetArtistAlbumsResult> {
        return artistRemoteDataSource.getArtistAlbums(params)
    }
}