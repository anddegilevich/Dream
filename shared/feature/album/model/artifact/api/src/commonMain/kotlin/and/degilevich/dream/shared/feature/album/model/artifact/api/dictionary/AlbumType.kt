package and.degilevich.dream.shared.feature.album.model.artifact.api.dictionary

import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import kotlinx.serialization.Serializable

@Serializable
enum class AlbumType(override val id: String) : Identified {
    ALBUM("album"),
    SINGLE("single"),
    COMPILATION("compilation"),
    UNKNOWN("unknown")
}