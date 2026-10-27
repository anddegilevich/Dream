package and.degilevich.dream.shared.feature.artist.domain.model.core.api.method.getArtistAlbums

import and.degilevich.dream.shared.feature.album.domain.model.artifact.api.data.SimplifiedAlbumData

data class GetArtistAlbumsResult(
    val total: Int,
    val items: List<SimplifiedAlbumData>
)