package and.degilevich.dream.shared.feature.search.model.core.impl.mapper

import and.degilevich.dream.shared.core.service.api.model.method.search.SearchTracksOutput
import and.degilevich.dream.shared.feature.search.model.core.api.mapper.SearchTracksOutputToDataMapper
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchTracksData
import and.degilevich.dream.shared.feature.track.model.core.api.mapper.TrackOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import kotlin.collections.orEmpty

internal class SearchTracksOutputToDataMapperImpl(
    private val trackOutputToDataMapper: TrackOutputToDataMapper,
) : SearchTracksOutputToDataMapper {
    override fun map(item: SearchTracksOutput): SearchTracksData {
        return with(item) {
            SearchTracksData(
                items = items?.mapWith(trackOutputToDataMapper).orEmpty()
            )
        }
    }
}