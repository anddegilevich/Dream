package and.degilevich.dream.shared.feature.search.data.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.api.SearchApi
import and.degilevich.dream.shared.feature.search.data.mapper.api.remote.SearchResponseToResultMapper
import and.degilevich.dream.shared.feature.search.model.core.dictionary.SearchType
import and.degilevich.dream.shared.feature.search.model.core.method.search.SearchParams
import and.degilevich.dream.shared.feature.search.model.core.method.search.SearchResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.result.foldResultSuccess
import and.degilevich.dream.shared.template.data.impl.remote.BaseRemoteDataSource

internal class SearchRemoteDataSourceImpl(
    private val searchResponseToResultMapper: SearchResponseToResultMapper,
) : BaseRemoteDataSource(), SearchRemoteDataSource {

    private val searchApi: SearchApi by lazy { apiService.searchApi }

    override suspend fun search(params: SearchParams): Result<SearchResult> = runCatching {
        searchApi.search(
            q = params.query,
            type = params.types.mapNotNull { type ->
                when (type) {
                    SearchType.ALBUM -> SearchApi.TypeSearch.ALBUM
                    SearchType.ARTIST -> SearchApi.TypeSearch.ARTIST
                    SearchType.PLAYLIST -> SearchApi.TypeSearch.PLAYLIST
                    SearchType.TRACK -> SearchApi.TypeSearch.TRACK
                    SearchType.SHOW -> SearchApi.TypeSearch.SHOW
                    SearchType.EPISODE -> SearchApi.TypeSearch.EPISODE
                    SearchType.AUDIOBOOK -> SearchApi.TypeSearch.AUDIOBOOK
                    SearchType.UNKNOWN -> null
                }
            },
            limit = params.limit,
            offset = params.offset
        ).body()
    }.foldResultSuccess { response ->
        response.mapWith(searchResponseToResultMapper)
    }
}