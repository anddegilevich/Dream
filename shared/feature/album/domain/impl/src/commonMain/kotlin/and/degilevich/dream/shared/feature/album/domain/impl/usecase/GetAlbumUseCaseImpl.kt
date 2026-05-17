package and.degilevich.dream.shared.feature.album.domain.impl.usecase

import and.degilevich.dream.shared.feature.album.data.api.repository.AlbumRepository
import and.degilevich.dream.shared.feature.album.domain.api.usecase.GetAlbumUseCase
import and.degilevich.dream.shared.feature.album.model.core.method.getAlbum.GetAlbumParams
import and.degilevich.dream.shared.feature.album.model.core.method.getAlbum.GetAlbumResult

internal class GetAlbumUseCaseImpl(
    private val albumRepository: AlbumRepository
) : GetAlbumUseCase {

    override suspend fun invoke(params: GetAlbumParams): Result<GetAlbumResult> {
        return albumRepository.getAlbum(params = params).onSuccess { result ->
            albumRepository.cacheAlbum(album = result.album)
        }
    }
}
