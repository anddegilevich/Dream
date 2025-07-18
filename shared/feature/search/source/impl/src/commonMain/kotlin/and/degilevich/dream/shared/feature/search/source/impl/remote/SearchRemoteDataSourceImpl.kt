package and.degilevich.dream.shared.feature.search.source.impl.remote

import and.degilevich.dream.shared.feature.search.source.api.remote.SearchRemoteDataSource
import and.degilevich.dream.shared.feature.search.source.api.remote.request.search.SearchParams
import and.degilevich.dream.shared.feature.search.source.api.remote.request.search.SearchResult
import and.degilevich.dream.shared.feature.search.source.impl.remote.mapper.SearchParamsToRequestMapper
import and.degilevich.dream.shared.feature.search.source.impl.remote.mapper.SearchResponseToResultMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.result.foldResultSuccess
import and.degilevich.dream.shared.template.source.impl.remote.BaseRemoteDataSource

internal class SearchRemoteDataSourceImpl(
    private val searchParamsToRequestMapper: SearchParamsToRequestMapper,
    private val searchResponseToResultMapper: SearchResponseToResultMapper,
) : BaseRemoteDataSource(), SearchRemoteDataSource {
    override suspend fun search(params: SearchParams): Result<SearchResult> {
        return service.search(
            request = params.mapWith(searchParamsToRequestMapper)
        ).foldResultSuccess { response ->
            response.mapWith(searchResponseToResultMapper)
        }
    }
}