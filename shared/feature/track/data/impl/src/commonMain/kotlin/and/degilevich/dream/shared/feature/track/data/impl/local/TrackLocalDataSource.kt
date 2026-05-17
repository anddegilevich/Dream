package and.degilevich.dream.shared.feature.track.data.impl.local

import and.degilevich.dream.shared.feature.track.model.core.data.TrackData

internal interface TrackLocalDataSource {
    suspend fun saveTracks(tracks: List<TrackData>)
    suspend fun saveTrack(track: TrackData)
}