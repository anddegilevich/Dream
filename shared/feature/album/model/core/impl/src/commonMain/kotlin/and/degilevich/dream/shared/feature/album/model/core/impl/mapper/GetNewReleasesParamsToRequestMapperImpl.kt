package and.degilevich.dream.shared.feature.album.model.core.impl.mapper

import and.degilevich.dream.shared.core.service.api.requests.getNewReleases.GetNewReleasesRequest
import and.degilevich.dream.shared.feature.album.model.core.api.mapper.GetNewReleasesParamsToRequestMapper
import and.degilevich.dream.shared.feature.album.model.core.api.request.getNewReleases.GetNewReleasesParams

internal class GetNewReleasesParamsToRequestMapperImpl : GetNewReleasesParamsToRequestMapper {
    override fun map(item: GetNewReleasesParams): GetNewReleasesRequest {
        return with(item) {
            GetNewReleasesRequest(
                limit = limit,
                offset = offset
            )
        }
    }
}