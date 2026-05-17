package and.degilevich.dream.shared.feature.search.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.model.method.search.SearchRequest
import and.degilevich.dream.shared.feature.search.model.core.method.search.SearchParams
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface SearchParamsToRequestMapper : Mapper<SearchParams, SearchRequest>