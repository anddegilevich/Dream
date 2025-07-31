package and.degilevich.dream.shared.feature.search.model.core.api.method.search

import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import kotlinx.serialization.Serializable

@Serializable
data class SearchTracksData(
    val items: List<TrackData>
) {
    companion object : EmptyFactory<SearchTracksData> {
        override fun empty(): SearchTracksData {
            return SearchTracksData(
                items = emptyList()
            )
        }
    }
}