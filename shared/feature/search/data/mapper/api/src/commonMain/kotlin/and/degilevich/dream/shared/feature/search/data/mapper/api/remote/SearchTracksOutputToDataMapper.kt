package and.degilevich.dream.shared.feature.search.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.model.method.search.SearchTracksOutput
import and.degilevich.dream.shared.feature.search.model.core.method.search.SearchTracksData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface SearchTracksOutputToDataMapper : Mapper<SearchTracksOutput, SearchTracksData>