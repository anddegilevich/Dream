package and.degilevich.dream.shared.feature.track.data.api.remote

import and.degilevich.dream.shared.feature.track.model.core.method.getTrack.GetTrackParams
import and.degilevich.dream.shared.feature.track.model.core.method.getTrack.GetTrackResult

interface TrackRemoteDataSource {
    suspend fun getTrack(params: GetTrackParams): Result<GetTrackResult>
}
