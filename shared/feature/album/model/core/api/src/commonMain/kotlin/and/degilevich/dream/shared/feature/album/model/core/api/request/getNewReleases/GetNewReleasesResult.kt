package and.degilevich.dream.shared.feature.album.model.core.api.request.getNewReleases

import and.degilevich.dream.shared.feature.album.model.core.api.data.NewReleasesAlbumsData

data class GetNewReleasesResult(
    val albums: NewReleasesAlbumsData
)