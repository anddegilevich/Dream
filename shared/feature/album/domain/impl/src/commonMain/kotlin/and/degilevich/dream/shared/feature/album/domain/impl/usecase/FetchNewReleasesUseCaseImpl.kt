package and.degilevich.dream.shared.feature.album.domain.impl.usecase

import and.degilevich.dream.shared.feature.album.domain.api.usecase.FetchNewReleasesUseCase
import and.degilevich.dream.shared.feature.album.model.core.api.method.getNewReleases.GetNewReleasesParams
import and.degilevich.dream.shared.feature.album.model.core.api.method.getNewReleases.GetNewReleasesResult
import and.degilevich.dream.shared.feature.album.source.api.local.AlbumLocalDataSource
import and.degilevich.dream.shared.feature.search.model.core.api.dictionary.SearchType
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchParams
import and.degilevich.dream.shared.feature.search.source.api.remote.SearchRemoteDataSource

internal class FetchNewReleasesUseCaseImpl(
    private val searchRemoteDataSource: SearchRemoteDataSource,
    private val albumLocalDataSource: AlbumLocalDataSource
) : FetchNewReleasesUseCase {

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