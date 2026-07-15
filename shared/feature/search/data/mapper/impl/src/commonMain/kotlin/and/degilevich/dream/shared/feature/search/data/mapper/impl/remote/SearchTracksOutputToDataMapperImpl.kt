package and.degilevich.dream.shared.feature.search.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PagingTrackObject
import and.degilevich.dream.shared.feature.search.data.mapper.api.remote.SearchTracksOutputToDataMapper
import and.degilevich.dream.shared.feature.search.model.core.method.search.SearchTracksData
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.TrackOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class SearchTracksOutputToDataMapperImpl(
    private val trackOutputToDataMapper: TrackOutputToDataMapper,
) : SearchTracksOutputToDataMapper {

    override fun map(item: PagingTrackObject): SearchTracksData = with(item) {
        SearchTracksData(
            items = items.mapWith(trackOutputToDataMapper)
        )
    }
}