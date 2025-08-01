package and.degilevich.dream.shared.feature.search.model.core.api.method.search

import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.empty.state.EmptyState
import kotlinx.serialization.Serializable

@Serializable
data class SearchTracksData(
    val items: List<TrackData>
) : EmptyState {

    override fun isEmpty(): Boolean {
        return items.isEmpty()
    }
    companion object : EmptyFactory<SearchTracksData> {
        override fun empty(): SearchTracksData {
            return SearchTracksData(
                items = emptyList()
            )
        }
    }
}