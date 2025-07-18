package and.degilevich.dream.shared.feature.search.model.core.api.mapper

import and.degilevich.dream.shared.core.service.api.requests.search.SearchResponse
import and.degilevich.dream.shared.feature.search.model.core.api.request.search.SearchResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface SearchResponseToResultMapper : Mapper<SearchResponse, SearchResult>