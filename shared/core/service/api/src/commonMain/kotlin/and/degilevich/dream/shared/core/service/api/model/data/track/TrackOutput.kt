package and.degilevich.dream.shared.core.service.api.model.data.track

import and.degilevich.dream.shared.core.service.api.model.data.album.AlbumSimplifiedOutput
import and.degilevich.dream.shared.core.service.api.model.data.artist.ArtistSimplifiedOutput
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrackOutput(

    @SerialName("id")
    val id: String? = null,

    @SerialName("name")
    val name: String? = null,

    @SerialName("album")
    val album: AlbumSimplifiedOutput? = null,

    @SerialName("track_number")
    val trackNumber: Int? = null,

    @SerialName("duration_ms")
    val durationMs: Int? = null,

    @SerialName("artists")
    val artists: List<ArtistSimplifiedOutput>? = null
)
