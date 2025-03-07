package and.degilevich.dream.shared.feature.track.model.artifact.abstraction

import and.degilevich.dream.shared.feature.artist.model.artifact.data.ArtistSimplifiedData
import and.degilevich.dream.shared.foundation.abstraction.empty.state.EmptyState
import and.degilevich.dream.shared.foundation.abstraction.id.Identified

interface TrackInfo : Identified, EmptyState {
    val name: String
    val trackNumber: Int
    val durationMs: Int
    val artists: List<ArtistSimplifiedData>
}