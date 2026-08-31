package and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks

import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData

data class GetSavedTracksResult(
    val tracks: List<TrackData>,
    val total: Int
)
