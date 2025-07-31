package and.degilevich.dream.shared.feature.search.model.core.api.mapper

import and.degilevich.dream.shared.core.service.api.model.method.search.SearchArtistsOutput
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchArtistsData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface SearchArtistsOutputToDataMapper : Mapper<SearchArtistsOutput, SearchArtistsData>