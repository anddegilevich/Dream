package and.degilevich.dream.shared.feature.album.domain.api.usecase

import and.degilevich.dream.shared.feature.album.model.core.api.request.getNewReleases.GetNewReleasesParams
import and.degilevich.dream.shared.feature.album.model.core.api.request.getNewReleases.GetNewReleasesResult

interface FetchNewReleasesUseCase {
    suspend operator fun invoke(params: GetNewReleasesParams): Result<GetNewReleasesResult>
}