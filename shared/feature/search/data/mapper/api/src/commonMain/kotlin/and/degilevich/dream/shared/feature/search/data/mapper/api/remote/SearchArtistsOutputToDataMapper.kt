package and.degilevich.dream.shared.feature.search.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PagingArtistObject
import and.degilevich.dream.shared.feature.search.model.core.method.search.SearchArtistsData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface SearchArtistsOutputToDataMapper : Mapper<PagingArtistObject, SearchArtistsData>