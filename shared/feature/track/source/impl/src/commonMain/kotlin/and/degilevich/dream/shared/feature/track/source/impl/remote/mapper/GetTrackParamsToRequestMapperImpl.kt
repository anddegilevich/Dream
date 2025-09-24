package and.degilevich.dream.shared.feature.track.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getTrack.GetTrackRequest
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackParams
import and.degilevich.dream.shared.feature.track.source.api.remote.mapper.GetTrackParamsToRequestMapper

internal class GetTrackParamsToRequestMapperImpl : GetTrackParamsToRequestMapper {

    override fun map(item: GetTrackParams): GetTrackRequest {
        return with(item) {
            GetTrackRequest(
                id = id
            )
        }
    }
}