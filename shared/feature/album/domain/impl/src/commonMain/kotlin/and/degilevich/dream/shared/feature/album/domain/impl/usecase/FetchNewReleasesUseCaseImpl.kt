package and.degilevich.dream.shared.feature.album.domain.impl.usecase

import and.degilevich.dream.shared.feature.album.domain.api.usecase.FetchNewReleasesUseCase
import and.degilevich.dream.shared.feature.album.model.core.api.method.getNewReleases.GetNewReleasesParams
import and.degilevich.dream.shared.feature.album.model.core.api.method.getNewReleases.GetNewReleasesResult
import and.degilevich.dream.shared.feature.album.source.api.local.AlbumLocalDataSource
import and.degilevich.dream.shared.feature.album.source.api.remote.AlbumRemoteDataSource

internal class FetchNewReleasesUseCaseImpl(
    private val albumRemoteDataSource: AlbumRemoteDataSource,
    private val albumLocalDataSource: AlbumLocalDataSource
) : FetchNewReleasesUseCase {

    override suspend fun invoke(params: GetNewReleasesParams): Result<GetNewReleasesResult> {
        return albumRemoteDataSource.getNewReleases(params = params).onSuccess { result ->
            albumLocalDataSource.saveAlbums(albums = result.albums.albums)
        }
    }
}