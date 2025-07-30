package and.degilevich.dream.shared.core.service.api.model.method.search

import and.degilevich.dream.shared.core.service.api.model.data.album.AlbumSimplifiedOutput
import and.degilevich.dream.shared.core.service.api.model.data.artist.ArtistOutput
import and.degilevich.dream.shared.core.service.api.model.data.track.TrackOutput
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//FIXME: Update scheme
@Serializable
data class SearchResponse(
    @SerialName("tracks")
    val tracks: List<TrackOutput>?,
    @SerialName("artists")
    val artists: List<ArtistOutput>?,
    @SerialName("albums")
    val albums: List<AlbumSimplifiedOutput>?,
)
