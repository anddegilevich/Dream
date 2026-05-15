package and.degilevich.dream.shared.feature.track.data.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getTrack.GetTrackRequest
import and.degilevich.dream.shared.feature.track.model.core.method.getTrack.GetTrackParams
import and.degilevich.dream.shared.feature.track.data.api.remote.mapper.GetTrackParamsToRequestMapper

internal class GetTrackParamsToRequestMapperImpl : GetTrackParamsToRequestMapper {

    override fun map(item: GetTrackParams): GetTrackRequest = with(item) {
        GetTrackRequest(
            id = id.value
        )
    }
}