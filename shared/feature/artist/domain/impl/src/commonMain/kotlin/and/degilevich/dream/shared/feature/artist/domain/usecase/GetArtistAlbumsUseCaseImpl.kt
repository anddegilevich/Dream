package and.degilevich.dream.shared.feature.artist.domain.usecase

import and.degilevich.dream.shared.feature.album.data.api.repository.AlbumRepository
import and.degilevich.dream.shared.feature.artist.data.api.repository.ArtistRepository
import and.degilevich.dream.shared.feature.artist.domain.api.usecase.GetArtistAlbumsUseCase
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtistAlbums.GetArtistAlbumsParams
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtistAlbums.GetArtistAlbumsResult

internal class GetArtistAlbumsUseCaseImpl(
    private val artistRepository: ArtistRepository,
    private val albumRepository: AlbumRepository
) : GetArtistAlbumsUseCase {

    override suspend fun invoke(params: GetArtistAlbumsParams): Result<GetArtistAlbumsResult> {
        return artistRepository.getArtistAlbums(params = params).onSuccess { result ->
            albumRepository.cacheAlbums(albums = result.items)
        }
    }
}
