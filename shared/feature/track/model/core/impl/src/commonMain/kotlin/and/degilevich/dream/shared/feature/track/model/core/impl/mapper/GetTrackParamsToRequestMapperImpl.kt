package and.degilevich.dream.shared.feature.track.model.core.impl.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getTrack.GetTrackRequest
import and.degilevich.dream.shared.feature.track.model.core.api.mapper.GetTrackParamsToRequestMapper
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackParams

internal class GetTrackParamsToRequestMapperImpl : GetTrackParamsToRequestMapper {
    override fun map(item: GetTrackParams): GetTrackRequest {
        return with(item) {
            GetTrackRequest(
                id = id
            )
        }
    }
}