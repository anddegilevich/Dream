package and.degilevich.dream.shared.feature.artist.model.core.method.getArtistAlbums

import and.degilevich.dream.shared.feature.album.model.artifact.data.AlbumSimplifiedData

data class GetArtistAlbumsResult(
    val total: Int,
    val items: List<AlbumSimplifiedData>
)