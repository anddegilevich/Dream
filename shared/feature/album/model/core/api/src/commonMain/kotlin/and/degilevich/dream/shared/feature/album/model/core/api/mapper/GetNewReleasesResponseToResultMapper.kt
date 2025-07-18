package and.degilevich.dream.shared.feature.album.model.core.api.mapper

import and.degilevich.dream.shared.core.service.api.requests.getNewReleases.GetNewReleasesResponse
import and.degilevich.dream.shared.feature.album.model.core.api.request.getNewReleases.GetNewReleasesResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetNewReleasesResponseToResultMapper : Mapper<GetNewReleasesResponse, GetNewReleasesResult>