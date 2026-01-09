package and.degilevich.dream.shared.feature.artist.model.artifact.api.dictionary

import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import kotlinx.serialization.Serializable

@Serializable
enum class ArtistType(override val id: Identifier) : Identified {
    ARTIST(id = Identifier("artist")),
    UNKNOWN(id = Identifier("unknown"))
}