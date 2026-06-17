package and.degilevich.dream.shared.feature.album.model.core.method.getNewReleases

import and.degilevich.dream.shared.feature.album.model.artifact.data.SimplifiedAlbumData

data class GetNewReleasesResult(
    val albums: List<SimplifiedAlbumData>
)