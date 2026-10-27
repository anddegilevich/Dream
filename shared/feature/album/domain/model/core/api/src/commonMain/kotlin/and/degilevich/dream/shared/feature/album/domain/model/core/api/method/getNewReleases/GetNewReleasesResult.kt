package and.degilevich.dream.shared.feature.album.domain.model.core.api.method.getNewReleases

import and.degilevich.dream.shared.feature.album.domain.model.artifact.api.data.SimplifiedAlbumData

data class GetNewReleasesResult(
    val albums: List<SimplifiedAlbumData>
)