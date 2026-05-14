package and.degilevich.dream.shared.feature.track.source.impl.remote

import and.degilevich.dream.shared.feature.track.model.core.method.getTrack.GetTrackParams
import and.degilevich.dream.shared.feature.track.model.core.method.getTrack.GetTrackResult
import and.degilevich.dream.shared.feature.track.source.api.remote.TrackRemoteDataSource
import and.degilevich.dream.shared.feature.track.source.api.remote.mapper.GetTrackParamsToRequestMapper
import and.degilevich.dream.shared.feature.track.source.api.remote.mapper.GetTrackResponseToResultMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.result.foldResultSuccess
import and.degilevich.dream.shared.template.source.impl.remote.BaseRemoteDataSource

internal class TrackRemoteDataSourceImpl(
    private val getTrackParamsToRequestMapper: GetTrackParamsToRequestMapper,
    private val getTrackResponseToResultMapper: GetTrackResponseToResultMapper,
) : BaseRemoteDataSource(), TrackRemoteDataSource {

    override suspend fun getTrack(params: GetTrackParams): Result<GetTrackResult> {
        return service.getTrack(
            request = params.mapWith(getTrackParamsToRequestMapper)
        ).foldResultSuccess { response ->
            response.mapWith(getTrackResponseToResultMapper)
        }
    }
}