package and.degilevich.dream.shared.feature.track.data.impl.remote

import and.degilevich.dream.shared.core.service.api.ApiService
import and.degilevich.dream.shared.core.service.api.generated.api.TracksApi
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.SavedTracksOutputToResultMapper
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.TrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksResult
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class TrackRemoteDataSourceImpl(
    private val apiService: ApiService,
    private val trackOutputToDataMapper: TrackOutputToDataMapper,
    private val savedTracksOutputToResultMapper: SavedTracksOutputToResultMapper,
) : TrackRemoteDataSource {

    private val tracksApi: TracksApi by lazy { apiService.tracksApi }

    override suspend fun getTrack(params: GetTrackParams): Result<GetTrackResult> = runCatching {
        tracksApi.getTrack(
            id = params.id.value
        ).body()
    }.map { response ->
        GetTrackResult(
            track = response.mapWith(trackOutputToDataMapper)
        )
    }

    override suspend fun getSavedTracks(
        params: GetSavedTracksParams
    ): Result<GetSavedTracksResult> = runCatching {
        tracksApi.getUsersSavedTracks(
            limit = params.limit,
            offset = params.offset
        ).body()
    }.map { response ->
        response.mapWith(savedTracksOutputToResultMapper)
    }
}
