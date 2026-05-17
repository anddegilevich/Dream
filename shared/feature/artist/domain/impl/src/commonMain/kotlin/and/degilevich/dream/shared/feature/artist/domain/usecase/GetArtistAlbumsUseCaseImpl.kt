package and.degilevich.dream.shared.feature.artist.domain.usecase

import and.degilevich.dream.shared.feature.album.data.api.local.AlbumLocalDataSource
import and.degilevich.dream.shared.feature.artist.domain.api.usecase.GetArtistAlbumsUseCase
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtistAlbums.GetArtistAlbumsParams
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtistAlbums.GetArtistAlbumsResult
import and.degilevich.dream.shared.feature.artist.data.api.remote.ArtistRemoteDataSource

internal class GetArtistAlbumsUseCaseImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val albumLocalDataSource: AlbumLocalDataSource
) : GetArtistAlbumsUseCase {

    override suspend fun invoke(params: GetArtistAlbumsParams): Result<GetArtistAlbumsResult> {
        return artistRemoteDataSource.getArtistAlbums(params = params).onSuccess { result ->
            albumLocalDataSource.saveAlbums(albums = result.items)
        }
    }
}