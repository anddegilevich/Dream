package and.degilevich.dream.shared.feature.artist.domain.usecase

import and.degilevich.dream.shared.feature.album.source.api.local.AlbumLocalDataSource
import and.degilevich.dream.shared.feature.artist.domain.api.usecase.FetchArtistAlbumsUseCase
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistAlbums.GetArtistAlbumsParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistAlbums.GetArtistAlbumsResult
import and.degilevich.dream.shared.feature.artist.source.api.remote.ArtistRemoteDataSource

internal class FetchArtistAlbumsUseCaseImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val albumLocalDataSource: AlbumLocalDataSource
) : FetchArtistAlbumsUseCase {

    override suspend fun invoke(params: GetArtistAlbumsParams): Result<GetArtistAlbumsResult> {
        return artistRemoteDataSource.getArtistAlbums(params = params).onSuccess { result ->
            albumLocalDataSource.saveAlbums(albums = result.items)
        }
    }
}