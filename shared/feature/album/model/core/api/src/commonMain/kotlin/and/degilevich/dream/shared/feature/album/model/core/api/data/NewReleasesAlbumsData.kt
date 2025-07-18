package and.degilevich.dream.shared.feature.album.model.core.api.data

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