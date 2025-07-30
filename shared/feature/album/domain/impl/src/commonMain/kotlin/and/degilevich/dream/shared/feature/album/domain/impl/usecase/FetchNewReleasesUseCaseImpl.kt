package and.degilevich.dream.shared.feature.album.domain.impl.usecase

import and.degilevich.dream.shared.feature.album.domain.api.usecase.FetchNewReleasesUseCase
import and.degilevich.dream.shared.feature.album.model.core.api.method.getNewReleases.GetNewReleasesParams
import and.degilevich.dream.shared.feature.album.model.core.api.method.getNewReleases.GetNewReleasesResult
import and.degilevich.dream.shared.feature.album.source.api.remote.AlbumRemoteDataSource

internal class FetchNewReleasesUseCaseImpl(
    private val remoteDataSource: AlbumRemoteDataSource
) : FetchNewReleasesUseCase {
    override suspend fun invoke(params: GetNewReleasesParams): Result<GetNewReleasesResult> {
        return remoteDataSource.getNewReleases(params)
    }
}