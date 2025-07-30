package and.degilevich.dream.shared.feature.album.domain.impl.usecase

import and.degilevich.dream.shared.feature.album.domain.api.usecase.FetchAlbumUseCase
import and.degilevich.dream.shared.feature.album.model.core.api.method.getAlbum.GetAlbumParams
import and.degilevich.dream.shared.feature.album.model.core.api.method.getAlbum.GetAlbumResult
import and.degilevich.dream.shared.feature.album.source.api.remote.AlbumRemoteDataSource

internal class FetchAlbumUseCaseImpl(
    private val albumRemoteDataSource: AlbumRemoteDataSource
) : FetchAlbumUseCase {
    override suspend fun invoke(params: GetAlbumParams): Result<GetAlbumResult> {
        return albumRemoteDataSource.getAlbum(params)
    }
}