package and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistAlbums

import and.degilevich.dream.shared.foundation.abstraction.id.Identifier

data class GetArtistAlbumsParams(
    val id: Identifier,
    val limit: Int,
    val offset: Int
)