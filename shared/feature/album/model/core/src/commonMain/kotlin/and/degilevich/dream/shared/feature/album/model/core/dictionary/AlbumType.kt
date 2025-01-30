package and.degilevich.dream.shared.feature.album.model.core.dictionary

import and.degilevich.dream.shared.foundation.model.id.Identified

enum class AlbumType(override val id: String) : Identified {
    ALBUM("album"),
    SINGLE("single"),
    COMPILATION("compilation"),
    UNKNOWN("unknown")
}