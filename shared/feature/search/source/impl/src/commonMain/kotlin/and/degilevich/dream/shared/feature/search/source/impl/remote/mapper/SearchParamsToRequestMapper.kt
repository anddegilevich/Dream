package and.degilevich.dream.shared.feature.search.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.requests.search.SearchRequest
import and.degilevich.dream.shared.feature.search.source.api.remote.request.search.SearchParams
import and.degilevich.dream.shared.foundation.abstraction.id.ext.ids
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.primitive.collections.list.orNullIfEmpty

internal class SearchParamsToRequestMapper : Mapper<SearchParams, SearchRequest> {
    override fun map(item: SearchParams): SearchRequest {
        return with(item) {
            SearchRequest(
                q = query,
                limit = limit,
                offset = offset,
                type = types.ids().orNullIfEmpty()
            )
        }
    }
}