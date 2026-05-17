package and.degilevich.dream.shared.feature.track.data.impl.remote

import and.degilevich.dream.shared.feature.track.model.core.method.getTrack.GetTrackParams
import and.degilevich.dream.shared.feature.track.model.core.method.getTrack.GetTrackResult

internal interface TrackRemoteDataSource {
    suspend fun getTrack(params: GetTrackParams): Result<GetTrackResult>
}