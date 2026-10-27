package and.degilevich.dream.shared.feature.artist.domain.model.core.api.method.getArtists

import and.degilevich.dream.shared.feature.artist.domain.model.artifact.api.data.ArtistId

data class GetArtistsParams(
    val ids: List<ArtistId>
)
