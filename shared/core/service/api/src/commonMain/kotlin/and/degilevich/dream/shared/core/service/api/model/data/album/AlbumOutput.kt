package and.degilevich.dream.shared.core.service.api.model.data.album

import and.degilevich.dream.shared.core.service.api.model.data.artist.ArtistSimplifiedOutput
import and.degilevich.dream.shared.core.service.api.model.data.image.ImageObjectOutput
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AlbumOutput(

    @SerialName("id")
    val id: String? = null,

    @SerialName("name")
    val name: String? = null,

    @SerialName("album_type")
    val albumType: String? = null,

    @SerialName("total_tracks")
    val totalTracks: Int? = null,

    @SerialName("release_date")
    val releaseDate: String? = null,

    @SerialName("artists")
    val artists: List<ArtistSimplifiedOutput>? = null,

    @SerialName("images")
    val images: List<ImageObjectOutput>? = null,

    @SerialName("tracks")
    val tracks: AlbumTracksOutput? = null,
)