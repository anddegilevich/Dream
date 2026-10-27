package and.degilevich.dream.shared.feature.track.domain.model.core.api.method.getSavedTracks

import and.degilevich.dream.shared.feature.track.domain.model.core.api.data.SavedTrackData

data class GetSavedTracksResult(
    val tracks: List<SavedTrackData>,
    val total: Int
)
