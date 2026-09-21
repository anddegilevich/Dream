package and.degilevich.dream.shared.feature.track.data.api.repository

import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksResult
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackResult

interface TrackRepository {
    suspend fun getTrack(params: GetTrackParams): Result<GetTrackResult>
    suspend fun getSavedTracks(params: GetSavedTracksParams): Result<GetSavedTracksResult>
    suspend fun cacheTrack(track: TrackData)
    suspend fun cacheTracks(tracks: List<TrackData>)
}
