package and.degilevich.dream.shared.feature.search.model.core.test.method.search

import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchTracksData
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.feature.track.model.core.test.data.trackData

fun searchTracksData(
    items: List<TrackData> = listOf(trackData(id = "track-1"))
): SearchTracksData = SearchTracksData(
    items = items
)
