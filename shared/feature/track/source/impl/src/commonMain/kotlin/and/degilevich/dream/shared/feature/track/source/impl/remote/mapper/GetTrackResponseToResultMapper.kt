package and.degilevich.dream.shared.feature.track.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.requests.getTrack.GetTrackResponse
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.feature.track.model.core.api.mapper.TrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.source.api.remote.request.getTrack.GetTrackResult
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class GetTrackResponseToResultMapper(
    private val trackOutputToDataMapper: TrackOutputToDataMapper
) : Mapper<GetTrackResponse, GetTrackResult> {
    override fun map(item: GetTrackResponse): GetTrackResult {
        return GetTrackResult(
            track = item?.mapWith(trackOutputToDataMapper).orEmpty(TrackData)
        )
    }
}