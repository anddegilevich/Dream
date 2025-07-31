package and.degilevich.dream.shared.feature.search.model.core.api.mapper

import and.degilevich.dream.shared.core.service.api.model.method.search.SearchAlbumsOutput
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchAlbumsData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface SearchAlbumsOutputToDataMapper : Mapper<SearchAlbumsOutput, SearchAlbumsData>