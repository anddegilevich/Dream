package and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistTopTracks

import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData

data class GetArtistTopTracksResult(
    val tracks: List<TrackData>
)