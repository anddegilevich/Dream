package and.degilevich.dream.shared.core.service.api.requests.search

import and.degilevich.dream.shared.core.service.api.core.album.AlbumOutput
import and.degilevich.dream.shared.core.service.api.core.artist.ArtistOutput
import and.degilevich.dream.shared.core.service.api.core.track.TrackOutput
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponse(
    @SerialName("tracks")
    val tracks: List<TrackOutput>?,
    @SerialName("artists")
    val artists: List<ArtistOutput>?,
    @SerialName("albums")
    val albums: List<AlbumOutput>?,
)
