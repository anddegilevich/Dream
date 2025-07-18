package and.degilevich.dream.shared.feature.album.model.core.api.mapper

import and.degilevich.dream.shared.core.service.api.requests.getNewReleases.GetNewReleasesRequest
import and.degilevich.dream.shared.feature.album.model.core.api.request.getNewReleases.GetNewReleasesParams
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetNewReleasesParamsToRequestMapper : Mapper<GetNewReleasesParams, GetNewReleasesRequest>