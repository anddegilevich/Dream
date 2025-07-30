package and.degilevich.dream.shared.feature.album.source.api.remote

import and.degilevich.dream.shared.feature.album.model.core.api.method.getAlbum.GetAlbumParams
import and.degilevich.dream.shared.feature.album.model.core.api.method.getAlbum.GetAlbumResult
import and.degilevich.dream.shared.feature.album.model.core.api.method.getNewReleases.GetNewReleasesParams
import and.degilevich.dream.shared.feature.album.model.core.api.method.getNewReleases.GetNewReleasesResult

interface AlbumRemoteDataSource {
    suspend fun getAlbum(params: GetAlbumParams): Result<GetAlbumResult>
    suspend fun getNewReleases(params: GetNewReleasesParams): Result<GetNewReleasesResult>
}