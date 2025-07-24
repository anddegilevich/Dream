package and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtistAlbums

import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumSimplifiedData

data class GetArtistAlbumsResult(
    val total: Int,
    val items: List<AlbumSimplifiedData>
)