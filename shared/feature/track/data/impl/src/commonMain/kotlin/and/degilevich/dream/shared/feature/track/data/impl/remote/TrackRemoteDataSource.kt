package and.degilevich.dream.shared.feature.track.data.impl.remote

import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksResult
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackResult

internal interface TrackRemoteDataSource {
    suspend fun getTrack(params: GetTrackParams): Result<GetTrackResult>
    suspend fun getSavedTracks(params: GetSavedTracksParams): Result<GetSavedTracksResult>
}
