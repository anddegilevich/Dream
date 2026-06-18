package and.degilevich.dream.shared.feature.artist.model.core.method.getArtists

import and.degilevich.dream.shared.feature.artist.model.artifact.data.ArtistId

data class GetArtistsParams(
    val ids: List<ArtistId>
)
