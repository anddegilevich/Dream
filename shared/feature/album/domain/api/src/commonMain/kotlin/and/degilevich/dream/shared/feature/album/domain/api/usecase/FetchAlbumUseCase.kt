package and.degilevich.dream.shared.feature.album.domain.api.usecase

import and.degilevich.dream.shared.feature.album.model.core.api.method.getAlbum.GetAlbumParams
import and.degilevich.dream.shared.feature.album.model.core.api.method.getAlbum.GetAlbumResult

interface FetchAlbumUseCase {
    suspend operator fun invoke(params: GetAlbumParams): Result<GetAlbumResult>
}