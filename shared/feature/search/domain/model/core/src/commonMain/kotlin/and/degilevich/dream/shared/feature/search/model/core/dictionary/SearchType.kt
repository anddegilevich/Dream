package and.degilevich.dream.shared.feature.search.model.core.dictionary

import and.degilevich.dream.shared.foundation.abstraction.id.AnyIdentifier
import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import and.degilevich.dream.shared.foundation.abstraction.id.identifier
import kotlinx.serialization.Serializable

@Serializable
enum class SearchType(
    override val id: AnyIdentifier
) : Identified {
    ALBUM(id = identifier("album")),
    ARTIST(id = identifier("artist")),
    PLAYLIST(id = identifier("playlist")),
    TRACK(id = identifier("track")),
    SHOW(id = identifier("show")),
    EPISODE(id = identifier("episode")),
    AUDIOBOOK(id = identifier("audiobook")),
    UNKNOWN(id = identifier("unknown"))
}