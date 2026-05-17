package and.degilevich.dream.shared.feature.album.domain.impl.usecase

import and.degilevich.dream.shared.feature.album.data.api.repository.AlbumRepository
import and.degilevich.dream.shared.feature.album.domain.api.usecase.GetNewReleasesUseCase
import and.degilevich.dream.shared.feature.album.model.core.method.getNewReleases.GetNewReleasesParams
import and.degilevich.dream.shared.feature.album.model.core.method.getNewReleases.GetNewReleasesResult
import and.degilevich.dream.shared.feature.search.data.api.repository.SearchRepository
import and.degilevich.dream.shared.feature.search.model.core.dictionary.SearchType
import and.degilevich.dream.shared.feature.search.model.core.method.search.SearchParams

internal class GetNewReleasesUseCaseImpl(
    private val searchRepository: SearchRepository,
    private val albumRepository: AlbumRepository
) : GetNewReleasesUseCase {

    override suspend fun invoke(params: GetNewReleasesParams): Result<GetNewReleasesResult> {
        return searchRepository.search(
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
            albumRepository.cacheAlbums(albums = result.albums)
        }
    }

    private companion object {
        const val NEW_RELEASES_SEARCH_TAG = "tag:new"
    }
}