package and.degilevich.dream.shared.feature.search.source.api.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.search.SearchResponse
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface SearchResponseToResultMapper : Mapper<SearchResponse, SearchResult>