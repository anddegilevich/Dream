package and.degilevich.dream.shared.feature.track.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.model.method.getTrack.GetTrackResponse
import and.degilevich.dream.shared.feature.track.model.core.data.TrackData
import and.degilevich.dream.shared.feature.track.model.core.method.getTrack.GetTrackResult
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.GetTrackResponseToResultMapper
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.TrackOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class GetTrackResponseToResultMapperImpl(
    private val trackOutputToDataMapper: TrackOutputToDataMapper
) : GetTrackResponseToResultMapper {

    override fun map(item: GetTrackResponse): GetTrackResult = with(item) {
        GetTrackResult(
            track = this?.mapWith(trackOutputToDataMapper).orEmpty(TrackData)
        )
    }
}