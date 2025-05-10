package and.degilevich.dream.shared.feature.track.source.api.remote

import and.degilevich.dream.shared.feature.track.source.api.remote.request.getRecommendations.GetRecommendationsParams
import and.degilevich.dream.shared.feature.track.source.api.remote.request.getRecommendations.GetRecommendationsResult
import and.degilevich.dream.shared.feature.track.source.api.remote.request.getTrack.GetTrackParams
import and.degilevich.dream.shared.feature.track.source.api.remote.request.getTrack.GetTrackResult

interface TrackRemoteDataSource {
    suspend fun getRecommendations(params: GetRecommendationsParams): Result<GetRecommendationsResult>
    suspend fun getTrack(params: GetTrackParams): Result<GetTrackResult>
}
