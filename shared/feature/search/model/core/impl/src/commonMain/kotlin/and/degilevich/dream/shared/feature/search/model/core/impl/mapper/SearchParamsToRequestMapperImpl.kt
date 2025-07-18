package and.degilevich.dream.shared.feature.search.model.core.impl.mapper

import and.degilevich.dream.shared.core.service.api.requests.search.SearchRequest
import and.degilevich.dream.shared.feature.search.model.core.api.mapper.SearchParamsToRequestMapper
import and.degilevich.dream.shared.feature.search.model.core.api.request.search.SearchParams
import and.degilevich.dream.shared.foundation.abstraction.id.ext.ids
import and.degilevich.dream.shared.foundation.primitive.collections.list.orNullIfEmpty

internal class SearchParamsToRequestMapperImpl : SearchParamsToRequestMapper {
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