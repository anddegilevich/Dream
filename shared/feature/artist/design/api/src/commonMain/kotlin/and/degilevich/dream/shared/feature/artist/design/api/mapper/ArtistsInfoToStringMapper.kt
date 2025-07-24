package and.degilevich.dream.shared.feature.artist.design.api.mapper

import and.degilevich.dream.shared.feature.artist.model.artifact.api.abstraction.ArtistInfo

interface ArtistsInfoToStringMapper {
    fun map(artists: List<ArtistInfo>): String
}