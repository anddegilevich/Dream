package and.degilevich.dream.shared.feature.search.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.generated.api.SearchApi
import and.degilevich.dream.shared.feature.search.model.core.api.dictionary.SearchType
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface SearchTypeToRequestMapper : Mapper<SearchType, SearchApi.TypeSearch>