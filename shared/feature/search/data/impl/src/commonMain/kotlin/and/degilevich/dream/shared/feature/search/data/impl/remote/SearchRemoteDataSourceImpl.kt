package and.degilevich.dream.shared.feature.search.data.impl.remote

import and.degilevich.dream.shared.core.service.api.ApiService
import and.degilevich.dream.shared.core.service.api.generated.api.SearchApi
import and.degilevich.dream.shared.feature.search.data.mapper.api.remote.SearchResponseToResultMapper
import and.degilevich.dream.shared.feature.search.data.mapper.api.remote.SearchTypeToRequestMapper
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchParams
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class SearchRemoteDataSourceImpl(
    private val apiService: ApiService,
    private val searchResponseToResultMapper: SearchResponseToResultMapper,
    private val searchTypeToRequestMapper: SearchTypeToRequestMapper,
) : SearchRemoteDataSource {

    private val searchApi: SearchApi by lazy { apiService.searchApi }

    override suspend fun search(params: SearchParams): Result<SearchResult> = runCatching {
        searchApi.search(
            q = params.query,
            type = params.types.mapWith(searchTypeToRequestMapper),
            limit = params.limit,
            offset = params.offset
        ).body()
    }.map { response ->
        response.mapWith(searchResponseToResultMapper)
    }
}