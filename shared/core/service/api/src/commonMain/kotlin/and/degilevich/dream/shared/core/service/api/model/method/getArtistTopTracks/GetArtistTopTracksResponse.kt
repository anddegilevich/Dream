package and.degilevich.dream.shared.core.service.api.model.method.getArtistTopTracks

import and.degilevich.dream.shared.core.service.api.model.data.track.TrackOutput
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetArtistTopTracksResponse(

    @SerialName("tracks")
    val tracks: List<TrackOutput>?
)