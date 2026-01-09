package and.degilevich.dream.shared.feature.search.model.core.api.dictionary

import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier

enum class SearchType(override val id: Identifier) : Identified {
    ALBUM(id = Identifier("album")),
    ARTIST(id = Identifier("artist")),
    PLAYLIST(id = Identifier("playlist")),
    TRACK(id = Identifier("track")),
    SHOW(id = Identifier("show")),
    EPISODE(id = Identifier("episode")),
    AUDIOBOOK(id = Identifier("audiobook")),
    UNKNOWN(id = Identifier("unknown"))
}