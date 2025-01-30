package and.degilevich.dream.shared.feature.album.model.core

import and.degilevich.dream.shared.feature.track.model.artifact.TrackSimplifiedData
import and.degilevich.dream.shared.foundation.model.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.model.empty.state.EmptyState

interface AlbumTracksData : EmptyState {
    val items: List<TrackSimplifiedData>

    data class Base(
        override val items: List<TrackSimplifiedData>
    ) : AlbumTracksData {
        override fun isEmpty(): Boolean {
            return items.isEmpty()
        }
    }

    companion object : EmptyFactory<AlbumTracksData> {
        override fun empty(): AlbumTracksData {
            return Base(
                items = emptyList()
            )
        }
    }
}