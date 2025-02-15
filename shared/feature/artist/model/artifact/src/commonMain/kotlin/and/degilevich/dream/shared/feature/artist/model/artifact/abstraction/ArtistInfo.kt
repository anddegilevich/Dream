package and.degilevich.dream.shared.feature.artist.model.artifact.abstraction

import and.degilevich.dream.shared.feature.artist.model.artifact.dictionary.ArtistType
import and.degilevich.dream.shared.foundation.model.empty.state.EmptyState
import and.degilevich.dream.shared.foundation.model.id.Identified

interface ArtistInfo : Identified, EmptyState {
    val name: String
    val artistType: ArtistType
}