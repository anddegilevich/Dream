package and.degilevich.dream.shared.feature.artist.ui.api.mapper

import and.degilevich.dream.shared.feature.artist.model.artifact.abstraction.ArtistInfo

internal class ArtistsInfoToStringMapperImpl : ArtistsInfoToStringMapper {
    override fun map(artists: List<ArtistInfo>): String {
        return artists.joinToString(separator = ", ") { artist -> artist.name }
    }
}