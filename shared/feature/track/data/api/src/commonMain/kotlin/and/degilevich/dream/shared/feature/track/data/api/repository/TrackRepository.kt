package and.degilevich.dream.shared.feature.track.data.api.repository

import and.degilevich.dream.shared.feature.track.model.core.data.TrackData
import and.degilevich.dream.shared.feature.track.model.core.method.getTrack.GetTrackParams
import and.degilevich.dream.shared.feature.track.model.core.method.getTrack.GetTrackResult

interface TrackRepository {
    suspend fun getTrack(params: GetTrackParams): Result<GetTrackResult>
    suspend fun cacheTrack(track: TrackData)
    suspend fun cacheTracks(tracks: List<TrackData>)
}