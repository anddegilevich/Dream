package and.degilevich.dream.shared.feature.search.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.model.method.search.SearchArtistsOutput
import and.degilevich.dream.shared.feature.search.model.core.method.search.SearchArtistsData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface SearchArtistsOutputToDataMapper : Mapper<SearchArtistsOutput, SearchArtistsData>