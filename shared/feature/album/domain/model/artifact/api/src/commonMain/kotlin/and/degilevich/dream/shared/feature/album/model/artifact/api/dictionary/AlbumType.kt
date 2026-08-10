package and.degilevich.dream.shared.feature.album.model.artifact.api.dictionary

import and.degilevich.dream.shared.foundation.abstraction.id.AnyIdentifier
import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import and.degilevich.dream.shared.foundation.abstraction.id.identifier
import kotlinx.serialization.Serializable

@Serializable
enum class AlbumType(
    override val id: AnyIdentifier
) : Identified {
    ALBUM(id = identifier("album")),
    SINGLE(id = identifier("single")),
    COMPILATION(id = identifier("compilation")),
    UNKNOWN(id = identifier("unknown"))
}