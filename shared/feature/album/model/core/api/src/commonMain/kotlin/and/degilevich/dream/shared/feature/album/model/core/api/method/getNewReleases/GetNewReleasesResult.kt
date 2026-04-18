package and.degilevich.dream.shared.feature.album.model.core.api.method.getNewReleases

import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumSimplifiedData

data class GetNewReleasesResult(
    val albums: List<AlbumSimplifiedData>
)