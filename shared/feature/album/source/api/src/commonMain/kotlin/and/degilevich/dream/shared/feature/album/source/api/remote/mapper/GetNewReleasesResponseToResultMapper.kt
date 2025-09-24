package and.degilevich.dream.shared.feature.album.source.api.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getNewReleases.GetNewReleasesResponse
import and.degilevich.dream.shared.feature.album.model.core.api.method.getNewReleases.GetNewReleasesResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetNewReleasesResponseToResultMapper : Mapper<GetNewReleasesResponse, GetNewReleasesResult>