package and.degilevich.dream.shared.feature.album.model.artifact.api.dictionary

import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import kotlinx.serialization.Serializable

@Serializable
enum class AlbumType(override val id: Identifier) : Identified {
    ALBUM(id = Identifier("album")),
    SINGLE(id = Identifier("single")),
    COMPILATION(id = Identifier("compilation")),
    UNKNOWN(id = Identifier("unknown"))
}