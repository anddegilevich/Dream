package and.degilevich.dream.shared.feature.artist.model.core.method.getArtists

import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistData

data class GetArtistsResult(
    val artists: List<ArtistData>
)