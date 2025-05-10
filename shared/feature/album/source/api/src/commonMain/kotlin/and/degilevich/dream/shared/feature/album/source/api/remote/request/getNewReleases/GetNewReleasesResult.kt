package and.degilevich.dream.shared.feature.album.source.api.remote.request.getNewReleases

import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumData

data class GetNewReleasesResult(
    val total: Int,
    val albums: List<AlbumData>
)