package and.degilevich.dream.shared.feature.track.data.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.api.TracksApi
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.TrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.core.method.getTrack.GetTrackParams
import and.degilevich.dream.shared.feature.track.model.core.method.getTrack.GetTrackResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.result.foldResultSuccess
import and.degilevich.dream.shared.template.data.impl.remote.BaseRemoteDataSource

internal class TrackRemoteDataSourceImpl(
    private val trackOutputToDataMapper: TrackOutputToDataMapper,
) : BaseRemoteDataSource(), TrackRemoteDataSource {

    private val tracksApi: TracksApi by lazy { apiService.tracksApi }

    override suspend fun getTrack(params: GetTrackParams): Result<GetTrackResult> = runCatching {
        tracksApi.getTrack(
            id = params.id.value
        ).body()
    }.foldResultSuccess { response ->
        GetTrackResult(
            track = response.mapWith(trackOutputToDataMapper)
        )
    }
}