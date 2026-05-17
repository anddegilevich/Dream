package and.degilevich.dream.shared.feature.album.domain.impl.usecase

import and.degilevich.dream.shared.feature.album.domain.api.usecase.GetNewReleasesUseCase
import and.degilevich.dream.shared.feature.album.model.core.method.getNewReleases.GetNewReleasesParams
import and.degilevich.dream.shared.feature.album.model.core.method.getNewReleases.GetNewReleasesResult
import and.degilevich.dream.shared.feature.album.data.api.local.AlbumLocalDataSource
import and.degilevich.dream.shared.feature.search.model.core.dictionary.SearchType
import and.degilevich.dream.shared.feature.search.model.core.method.search.SearchParams
import and.degilevich.dream.shared.feature.search.data.api.remote.SearchRemoteDataSource

internal class GetNewReleasesUseCaseImpl(
    private val searchRemoteDataSource: SearchRemoteDataSource,
    private val albumLocalDataSource: AlbumLocalDataSource
) : GetNewReleasesUseCase {

    override suspend fun invoke(params: GetNewReleasesParams): Result<GetNewReleasesResult> {
        return searchRemoteDataSource.search(
            SearchParams(
                query = NEW_RELEASES_SEARCH_TAG,
                limit = params.limit,
                offset = params.offset,
                types = listOf(SearchType.ALBUM)
            )
        ).map { result ->
            GetNewReleasesResult(
                albums = result.albums.items
            )
        }.onSuccess { result ->
            albumLocalDataSource.saveAlbums(albums = result.albums)
        }
    }

    private companion object {
        const val NEW_RELEASES_SEARCH_TAG = "tag:new"
    }
}