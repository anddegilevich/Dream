package and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtistAlbums

data class GetArtistAlbumsParams(
    val id: String,
    val limit: Int,
    val offset: Int
)