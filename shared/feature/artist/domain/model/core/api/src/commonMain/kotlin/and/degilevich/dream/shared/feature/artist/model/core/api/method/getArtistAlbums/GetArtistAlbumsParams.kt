package and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistAlbums

import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.ArtistId

data class GetArtistAlbumsParams(
    val id: ArtistId,
    val limit: Int,
    val offset: Int
)