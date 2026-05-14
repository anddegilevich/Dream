package and.degilevich.dream.shared.feature.album.domain.api.usecase

import and.degilevich.dream.shared.feature.album.model.core.method.getNewReleases.GetNewReleasesParams
import and.degilevich.dream.shared.feature.album.model.core.method.getNewReleases.GetNewReleasesResult

interface FetchNewReleasesUseCase {
    suspend operator fun invoke(params: GetNewReleasesParams): Result<GetNewReleasesResult>
}