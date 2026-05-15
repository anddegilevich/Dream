package and.degilevich.dream.shared.feature.track.data.api.local

import and.degilevich.dream.shared.feature.track.model.core.data.TrackData

interface TrackLocalDataSource {
    suspend fun saveTracks(tracks: List<TrackData>)
    suspend fun saveTrack(track: TrackData)
}