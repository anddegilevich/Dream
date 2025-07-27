package and.degilevich.dream.shared.feature.artist.design.api.mapper

import and.degilevich.dream.shared.feature.artist.model.artifact.api.abstraction.ArtistInfo

internal class ArtistsInfoToStringMapperImpl : ArtistsInfoToStringMapper {
    override fun map(artists: List<ArtistInfo>): String {
        return artists.joinToString(separator = ", ") { artist -> artist.name }
    }
}