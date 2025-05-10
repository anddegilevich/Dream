package and.degilevich.dream.shared.feature.track.source.impl.remote

import and.degilevich.dream.shared.feature.track.source.api.remote.TrackRemoteDataSource
import and.degilevich.dream.shared.feature.track.source.api.remote.request.getRecommendations.GetRecommendationsParams
import and.degilevich.dream.shared.feature.track.source.api.remote.request.getRecommendations.GetRecommendationsResult
import and.degilevich.dream.shared.feature.track.source.api.remote.request.getTrack.GetTrackParams
import and.degilevich.dream.shared.feature.track.source.api.remote.request.getTrack.GetTrackResult
import and.degilevich.dream.shared.feature.track.source.impl.remote.mapper.GetRecommendationsParamsToRequestMapper
import and.degilevich.dream.shared.feature.track.source.impl.remote.mapper.GetRecommendationsResponseToResultMapper
import and.degilevich.dream.shared.feature.track.source.impl.remote.mapper.GetTrackParamsToRequestMapper
import and.degilevich.dream.shared.feature.track.source.impl.remote.mapper.GetTrackResponseToResultMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.result.foldResultSuccess
import and.degilevich.dream.shared.template.source.impl.remote.RemoteDataSourceTemplate

internal class TrackRemoteDataSourceImpl(
    private val getRecommendationsParamsToRequestMapper: GetRecommendationsParamsToRequestMapper,
    private val getRecommendationsResponseToResultMapper: GetRecommendationsResponseToResultMapper,
    private val getTrackParamsToRequestMapper: GetTrackParamsToRequestMapper,
    private val getTrackResponseToResultMapper: GetTrackResponseToResultMapper,
) : RemoteDataSourceTemplate(), TrackRemoteDataSource {

    override suspend fun getRecommendations(params: GetRecommendationsParams): Result<GetRecommendationsResult> {
        return service.getRecommendations(
            request = params.mapWith(getRecommendationsParamsToRequestMapper)
        ).foldResultSuccess { response ->
            response.mapWith(getRecommendationsResponseToResultMapper)
        }
    }

    override suspend fun getTrack(params: GetTrackParams): Result<GetTrackResult> {
        return service.getTrack(
            request = params.mapWith(getTrackParamsToRequestMapper)
        ).foldResultSuccess { response ->
            response.mapWith(getTrackResponseToResultMapper)
        }
    }
}