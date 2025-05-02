package and.degilevich.dream.shared.feature.artist.model.artifact.api.abstraction

import and.degilevich.dream.shared.feature.artist.model.artifact.api.dictionary.ArtistType
import and.degilevich.dream.shared.foundation.abstraction.empty.state.EmptyState
import and.degilevich.dream.shared.foundation.abstraction.id.Identified

interface ArtistInfo : Identified, EmptyState {
    val name: String
    val artistType: ArtistType
}