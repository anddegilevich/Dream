package and.degilevich.dream.shared.feature.artist.core.api.model.request.getArtists

import and.degilevich.dream.shared.feature.artist.core.api.model.ArtistData

data class GetArtistsResponse(
    val count: Int,
    val artists: List<ArtistData>
)