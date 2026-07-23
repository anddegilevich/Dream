package and.degilevich.dream.shared.feature.artist.model.artifact.dictionary

import and.degilevich.dream.shared.foundation.abstraction.id.AnyIdentifier
import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import and.degilevich.dream.shared.foundation.abstraction.id.identifier
import kotlinx.serialization.Serializable

@Serializable
enum class ArtistType(
    override val id: AnyIdentifier
) : Identified {
    ARTIST(id = identifier("artist")),
    UNKNOWN(id = identifier("unknown"))
}