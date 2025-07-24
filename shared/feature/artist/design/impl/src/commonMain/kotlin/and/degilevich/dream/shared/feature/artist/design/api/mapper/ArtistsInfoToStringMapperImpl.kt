package and.degilevich.dream.shared.feature.artist.design.api.mapper

import and.degilevich.dream.shared.feature.artist.model.artifact.api.abstraction.ArtistInfo

internal class ArtistsInfoToStringMapperImpl : ArtistsInfoToStringMapper {
    override fun map(artists: List<ArtistInfo>): String {
        return artists
            .map { artist -> artist.name }
            .fold(
                initial = ""
            ) { acc, name ->
                acc.run {
                    if (isNotEmpty()) plus(" . ")
                    plus(name)
                }
            }
    }
}