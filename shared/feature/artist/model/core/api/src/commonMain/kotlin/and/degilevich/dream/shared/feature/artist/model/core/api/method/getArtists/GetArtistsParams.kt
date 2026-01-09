package and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtists

import and.degilevich.dream.shared.foundation.abstraction.id.Identifier

data class GetArtistsParams(
    val ids: List<Identifier>
)
