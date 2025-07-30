package and.degilevich.dream.shared.feature.track.model.core.impl.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getTrack.GetTrackResponse
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.feature.track.model.core.api.mapper.GetTrackResponseToResultMapper
import and.degilevich.dream.shared.feature.track.model.core.api.mapper.TrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackResult
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class GetTrackResponseToResultMapperImpl(
    private val trackOutputToDataMapper: TrackOutputToDataMapper
) : GetTrackResponseToResultMapper {
    override fun map(item: GetTrackResponse): GetTrackResult {
        return GetTrackResult(
            track = item?.mapWith(trackOutputToDataMapper).orEmpty(TrackData)
        )
    }
}