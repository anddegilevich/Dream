package and.degilevich.dream.shared.feature.artist.model.artifact.api.dictionary

import and.degilevich.dream.shared.foundation.abstraction.id.Identified

enum class ArtistType(override val id: String) : Identified {
    ARTIST(id = "artist"),
    UNKNOWN(id = "unknown")
}