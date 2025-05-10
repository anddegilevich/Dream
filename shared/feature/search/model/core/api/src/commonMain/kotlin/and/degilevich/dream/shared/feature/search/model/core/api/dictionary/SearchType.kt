package and.degilevich.dream.shared.feature.search.model.core.api.dictionary

import and.degilevich.dream.shared.foundation.abstraction.id.Identified

enum class SearchType(override val id: String) : Identified {
    ALBUM("album"),
    ARTIST("artist"),
    PLAYLIST("playlist"),
    TRACK("track"),
    SHOW("show"),
    EPISODE("episode"),
    AUDIOBOOK("audiobook"),
    UNKNOWN("unknown")
}