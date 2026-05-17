package and.degilevich.dream.shared.feature.album.model.core.method.getNewReleases

import and.degilevich.dream.shared.feature.album.model.artifact.data.AlbumSimplifiedData

data class GetNewReleasesResult(
    val albums: List<AlbumSimplifiedData>
)