package and.degilevich.dream.shared.feature.album.model.core.data

import and.degilevich.dream.shared.feature.track.model.artifact.data.TrackSimplifiedData
import and.degilevich.dream.shared.foundation.model.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.model.empty.state.EmptyState
import kotlinx.serialization.Serializable

@Serializable
data class AlbumTracksData(
    val items: List<TrackSimplifiedData>
) : EmptyState {

    override fun isEmpty(): Boolean {
        return items.isEmpty()
    }

    companion object : EmptyFactory<AlbumTracksData> {
        override fun empty(): AlbumTracksData {
            return AlbumTracksData(
                items = emptyList()
            )
        }
    }
}