package and.degilevich.dream.shared.core.service.api.core.artist

import and.degilevich.dream.shared.core.service.api.core.image.ImageObjectOutput
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArtistOutput(
    @SerialName("id")
    val id: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("type")
    val type: String?,
    @SerialName("popularity")
    val popularity: Int?,
    @SerialName("genres")
    val genres: List<String>?,
    @SerialName("followers")
    val followers: ArtistFollowersOutput?,
    @SerialName("images")
    val images: List<ImageObjectOutput>?
)