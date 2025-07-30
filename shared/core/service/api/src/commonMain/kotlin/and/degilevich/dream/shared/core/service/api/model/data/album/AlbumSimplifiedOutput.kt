package and.degilevich.dream.shared.core.service.api.model.data.album

import and.degilevich.dream.shared.core.service.api.model.data.artist.ArtistSimplifiedOutput
import and.degilevich.dream.shared.core.service.api.model.data.image.ImageObjectOutput
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AlbumSimplifiedOutput(
    @SerialName("id")
    val id: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("album_type")
    val albumType: String?,
    @SerialName("total_tracks")
    val totalTracks: Int?,
    @SerialName("release_date")
    val releaseDate: String?,
    @SerialName("artists")
    val artists: List<ArtistSimplifiedOutput>?,
    @SerialName("images")
    val images: List<ImageObjectOutput>?,
)