package and.degilevich.dream.shared.feature.search.domain.model.core.test.method.search

import and.degilevich.dream.shared.feature.search.domain.model.core.api.method.search.SearchTracksData
import and.degilevich.dream.shared.feature.track.domain.model.core.api.data.TrackData
import and.degilevich.dream.shared.feature.track.domain.model.core.test.data.trackData

fun searchTracksData(
    items: List<TrackData> = listOf(trackData(id = "track-1")),
    total: Int = items.size
): SearchTracksData = SearchTracksData(
    items = items,
    total = total
)
