package and.degilevich.dream.shared.feature.track.source.api.remote

import and.degilevich.dream.shared.feature.track.model.core.api.request.getRecommendations.GetRecommendationsParams
import and.degilevich.dream.shared.feature.track.model.core.api.request.getRecommendations.GetRecommendationsResult
import and.degilevich.dream.shared.feature.track.model.core.api.request.getTrack.GetTrackParams
import and.degilevich.dream.shared.feature.track.model.core.api.request.getTrack.GetTrackResult

interface TrackRemoteDataSource {
    suspend fun getRecommendations(params: GetRecommendationsParams): Result<GetRecommendationsResult>
    suspend fun getTrack(params: GetTrackParams): Result<GetTrackResult>
}
