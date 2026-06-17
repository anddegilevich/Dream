package and.degilevich.dream.shared.feature.artist.data.mapper.impl.local

import and.degilevich.dream.shared.core.db.api.entity.ArtistEntity
import and.degilevich.dream.shared.feature.artist.data.mapper.api.local.SimplifiedArtistDataToEntityMapper
import and.degilevich.dream.shared.feature.artist.model.artifact.data.SimplifiedArtistData

internal class SimplifiedArtistDataToEntityMapperImpl : SimplifiedArtistDataToEntityMapper {

    override fun map(item: SimplifiedArtistData): ArtistEntity = with(item) {
        ArtistEntity(
            id = id.value,
            name = name,
            artistType = artistType.id.value
        )
    }
}