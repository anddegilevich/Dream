package and.degilevich.dream.shared.feature.album.source.api.remote.request.getNewReleases

import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumSimplifiedData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory

data class NewReleasesAlbumsData(
    val total: Int,
    val albums: List<AlbumSimplifiedData>
) {
    companion object : EmptyFactory<NewReleasesAlbumsData> {
        override fun empty(): NewReleasesAlbumsData {
            return NewReleasesAlbumsData(
                total = 0,
                albums = emptyList()
            )
        }
    }
}
