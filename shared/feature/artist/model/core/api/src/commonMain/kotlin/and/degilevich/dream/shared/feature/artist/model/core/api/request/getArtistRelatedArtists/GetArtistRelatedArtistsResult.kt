package and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtistRelatedArtists

import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData

data class GetArtistRelatedArtistsResult(
    val artists: List<ArtistData>
)