package and.degilevich.dream.shared.feature.track.data.api.repository

import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackResult

interface TrackRepository {
    suspend fun getTrack(params: GetTrackParams): Result<GetTrackResult>
    suspend fun cacheTrack(track: TrackData)
    suspend fun cacheTracks(tracks: List<TrackData>)
}