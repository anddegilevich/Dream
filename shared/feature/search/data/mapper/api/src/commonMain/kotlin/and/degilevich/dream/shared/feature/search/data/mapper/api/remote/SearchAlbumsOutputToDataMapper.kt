package and.degilevich.dream.shared.feature.search.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PagingSimplifiedAlbumObject
import and.degilevich.dream.shared.feature.search.model.core.method.search.SearchAlbumsData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface SearchAlbumsOutputToDataMapper : Mapper<PagingSimplifiedAlbumObject, SearchAlbumsData>