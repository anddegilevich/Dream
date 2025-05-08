package and.degilevich.dream.shared.core.service.api.requests.getArtistTopTracks

import and.degilevich.dream.shared.core.service.api.core.track.TrackOutput
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetArtistTopTracksResponse(
    @SerialName("tracks")
    val tracks: List<TrackOutput>?
)