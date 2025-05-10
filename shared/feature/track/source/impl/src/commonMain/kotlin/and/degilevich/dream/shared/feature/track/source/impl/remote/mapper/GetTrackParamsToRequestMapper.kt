package and.degilevich.dream.shared.feature.track.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.requests.getTrack.GetTrackRequest
import and.degilevich.dream.shared.feature.track.source.api.remote.request.getTrack.GetTrackParams
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

internal class GetTrackParamsToRequestMapper : Mapper<GetTrackParams, GetTrackRequest> {
    override fun map(item: GetTrackParams): GetTrackRequest {
        return with(item) {
            GetTrackRequest(
                id = id
            )
        }
    }
}