package and.degilevich.dream.shared.feature.artist.model.artifact.dictionary

import and.degilevich.dream.shared.foundation.model.id.Identified

enum class ArtistType(override val id: String) : Identified {
    ARTIST(id = "artist"),
    UNKNOWN(id = "unknown")
}