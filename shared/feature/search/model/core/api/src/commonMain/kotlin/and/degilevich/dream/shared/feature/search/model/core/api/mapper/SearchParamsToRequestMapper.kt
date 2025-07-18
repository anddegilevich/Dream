package and.degilevich.dream.shared.feature.search.model.core.api.mapper

import and.degilevich.dream.shared.core.service.api.requests.search.SearchRequest
import and.degilevich.dream.shared.feature.search.model.core.api.request.search.SearchParams
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface SearchParamsToRequestMapper : Mapper<SearchParams, SearchRequest>