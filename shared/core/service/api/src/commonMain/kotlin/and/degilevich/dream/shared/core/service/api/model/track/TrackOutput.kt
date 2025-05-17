package and.degilevich.dream.shared.core.service.api.model.track

import and.degilevich.dream.shared.core.service.api.model.album.AlbumSimplifiedOutput
import and.degilevich.dream.shared.core.service.api.model.artist.ArtistSimplifiedOutput
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrackOutput(
    @SerialName("id")
    val id: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("album")
    val album: AlbumSimplifiedOutput?,
    @SerialName("popularity")
    val popularity: Int?,
    @SerialName("track_number")
    val trackNumber: Int?,
    @SerialName("duration_ms")
    val durationMs: Int?,
    @SerialName("artists")
    val artists: List<ArtistSimplifiedOutput>?
)
