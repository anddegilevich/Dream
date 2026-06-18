package and.degilevich.dream.shared.feature.artist.model.core.method.getArtistAlbums

import and.degilevich.dream.shared.feature.artist.model.artifact.data.ArtistId

data class GetArtistAlbumsParams(
    val id: ArtistId,
    val limit: Int,
    val offset: Int
)