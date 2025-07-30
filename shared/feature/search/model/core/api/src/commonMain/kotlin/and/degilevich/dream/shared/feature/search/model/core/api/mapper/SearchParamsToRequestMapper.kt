package and.degilevich.dream.shared.feature.search.model.core.api.mapper

import and.degilevich.dream.shared.core.service.api.model.method.search.SearchRequest
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchParams
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface SearchParamsToRequestMapper : Mapper<SearchParams, SearchRequest>