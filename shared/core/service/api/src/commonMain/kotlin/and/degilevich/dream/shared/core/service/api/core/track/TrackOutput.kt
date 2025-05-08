package and.degilevich.dream.shared.core.service.api.core.track

import and.degilevich.dream.shared.core.service.api.core.album.AlbumOutput
import and.degilevich.dream.shared.core.service.api.core.artist.ArtistSimplifiedOutput
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrackOutput(
    @SerialName("id")
    val id: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("album")
    val album: AlbumOutput?,
    @SerialName("popularity")
    val popularity: Int?,
    @SerialName("track_number")
    val trackNumber: Int?,
    @SerialName("duration_ms")
    val durationMs: Int?,
    @SerialName("artists")
    val artists: List<ArtistSimplifiedOutput>?
)
