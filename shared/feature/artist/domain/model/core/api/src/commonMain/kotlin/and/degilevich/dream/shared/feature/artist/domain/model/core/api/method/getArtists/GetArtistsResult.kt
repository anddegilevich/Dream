package and.degilevich.dream.shared.feature.artist.domain.model.core.api.method.getArtists

import and.degilevich.dream.shared.feature.artist.domain.model.core.api.data.ArtistData

data class GetArtistsResult(
    val artists: List<ArtistData>
)