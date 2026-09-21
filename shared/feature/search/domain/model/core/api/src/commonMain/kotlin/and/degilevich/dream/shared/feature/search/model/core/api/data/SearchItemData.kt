package and.degilevich.dream.shared.feature.search.model.core.api.data

import and.degilevich.dream.shared.feature.album.model.artifact.api.data.SimplifiedAlbumData
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import kotlinx.serialization.Serializable

@Serializable
sealed interface SearchItemData : Identified {

    @Serializable
    data class Track(val track: TrackData) : SearchItemData {
        override val id: Identifier
            get() = track.id
    }

    @Serializable
    data class Artist(val artist: ArtistData) : SearchItemData {
        override val id: Identifier
            get() = artist.id
    }

    @Serializable
    data class Album(val album: SimplifiedAlbumData) : SearchItemData {
        override val id: Identifier
            get() = album.id
    }
}
