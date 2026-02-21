package and.degilevich.dream.shared.feature.artist.source.impl.local.mapper

import and.degilevich.dream.shared.core.db.api.entity.ArtistEntity
import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.ArtistSimplifiedData
import and.degilevich.dream.shared.feature.artist.source.api.local.mapper.ArtistSimplifiedDataToEntityMapper

internal class ArtistSimplifiedDataToEntityMapperImpl : ArtistSimplifiedDataToEntityMapper {

    override fun map(item: ArtistSimplifiedData): ArtistEntity = with(item) {
        ArtistEntity(
            id = id.id,
            name = name,
            artistType = artistType.id.id
        )
    }
}