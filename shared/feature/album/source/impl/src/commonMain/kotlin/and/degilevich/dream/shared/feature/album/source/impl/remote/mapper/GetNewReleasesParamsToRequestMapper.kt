package and.degilevich.dream.shared.feature.album.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.requests.getNewReleases.GetNewReleasesRequest
import and.degilevich.dream.shared.feature.album.source.api.remote.request.getNewReleases.GetNewReleasesParams
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

internal class GetNewReleasesParamsToRequestMapper : Mapper<GetNewReleasesParams, GetNewReleasesRequest> {
    override fun map(item: GetNewReleasesParams): GetNewReleasesRequest {
        return with(item) {
            GetNewReleasesRequest(
                limit = limit,
                offset = offset
            )
        }
    }
}