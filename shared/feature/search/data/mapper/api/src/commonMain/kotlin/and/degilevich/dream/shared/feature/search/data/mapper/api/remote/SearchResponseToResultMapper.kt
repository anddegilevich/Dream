package and.degilevich.dream.shared.feature.search.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.generated.model.Search200Response
import and.degilevich.dream.shared.feature.search.model.core.method.search.SearchResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface SearchResponseToResultMapper : Mapper<Search200Response, SearchResult>