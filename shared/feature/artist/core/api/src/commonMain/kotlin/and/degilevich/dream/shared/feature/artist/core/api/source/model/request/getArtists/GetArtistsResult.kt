package and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists

import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData

data class GetArtistsResult(
    val artists: List<ArtistData>
)