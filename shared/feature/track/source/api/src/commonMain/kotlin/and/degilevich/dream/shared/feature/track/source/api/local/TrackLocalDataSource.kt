package and.degilevich.dream.shared.feature.track.source.api.local

import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData

interface TrackLocalDataSource {
    suspend fun saveTracks(tracks: List<TrackData>)
    suspend fun saveTrack(track: TrackData)
}