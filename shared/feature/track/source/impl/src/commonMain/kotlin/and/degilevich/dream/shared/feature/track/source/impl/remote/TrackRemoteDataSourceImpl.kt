package and.degilevich.dream.shared.feature.track.source.impl.remote

import and.degilevich.dream.shared.feature.track.source.api.remote.TrackRemoteDataSource
import and.degilevich.dream.shared.feature.track.model.core.api.method.getRecommendations.GetRecommendationsParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getRecommendations.GetRecommendationsResult
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackResult
import and.degilevich.dream.shared.feature.track.source.api.remote.mapper.GetRecommendationsParamsToRequestMapper
import and.degilevich.dream.shared.feature.track.source.api.remote.mapper.GetRecommendationsResponseToResultMapper
import and.degilevich.dream.shared.feature.track.source.api.remote.mapper.GetTrackParamsToRequestMapper
import and.degilevich.dream.shared.feature.track.source.api.remote.mapper.GetTrackResponseToResultMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.result.foldResultSuccess
import and.degilevich.dream.shared.template.source.impl.remote.BaseRemoteDataSource

internal class TrackRemoteDataSourceImpl(
    private val getRecommendationsParamsToRequestMapper: GetRecommendationsParamsToRequestMapper,
    private val getRecommendationsResponseToResultMapper: GetRecommendationsResponseToResultMapper,
    private val getTrackParamsToRequestMapper: GetTrackParamsToRequestMapper,
    private val getTrackResponseToResultMapper: GetTrackResponseToResultMapper,
) : BaseRemoteDataSource(), TrackRemoteDataSource {

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