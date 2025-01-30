package and.degilevich.dream.shared.feature.track.model.artifact

import and.degilevich.dream.shared.feature.artist.model.artifact.ArtistSimplifiedData
import and.degilevich.dream.shared.foundation.model.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.model.empty.state.EmptyState
import and.degilevich.dream.shared.foundation.model.id.AbstractIdentified
import and.degilevich.dream.shared.foundation.model.id.Identified

interface TrackSimplifiedData : Identified, EmptyState {
    val name: String
    val trackNumber: Int
    val durationMs: Int
    val artists: List<ArtistSimplifiedData>

    data class Base(
        override val id: String,
        override val name: String,
        override val trackNumber: Int,
        override val durationMs: Int,
        override val artists: List<ArtistSimplifiedData>
    ) : AbstractIdentified(), TrackSimplifiedData

    companion object : EmptyFactory<TrackSimplifiedData> {
        override fun empty(): TrackSimplifiedData {
            return Base(
                id = "",
                name = "",
                trackNumber = 0,
                durationMs = 0,
                artists = emptyList()
            )
        }
    }
}