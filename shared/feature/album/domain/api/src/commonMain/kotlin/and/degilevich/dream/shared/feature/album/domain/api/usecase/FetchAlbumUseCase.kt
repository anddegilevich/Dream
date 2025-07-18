package and.degilevich.dream.shared.feature.album.domain.api.usecase

import and.degilevich.dream.shared.feature.album.model.core.api.request.getAlbum.GetAlbumParams
import and.degilevich.dream.shared.feature.album.model.core.api.request.getAlbum.GetAlbumResult

interface FetchAlbumUseCase {
    suspend operator fun invoke(params: GetAlbumParams): Result<GetAlbumResult>
}