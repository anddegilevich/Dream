package and.degilevich.dream.shared.feature.track.source.api.remote

import and.degilevich.dream.shared.feature.track.model.core.api.method.getRecommendations.GetRecommendationsParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getRecommendations.GetRecommendationsResult
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackResult

interface TrackRemoteDataSource {
    suspend fun getRecommendations(params: GetRecommendationsParams): Result<GetRecommendationsResult>
    suspend fun getTrack(params: GetTrackParams): Result<GetTrackResult>
}
