package and.degilevich.dream.shared.feature.album.source.impl.local.mapper

import and.degilevich.dream.shared.core.db.api.entity.AlbumEntity
import and.degilevich.dream.shared.feature.album.model.artifact.data.AlbumSimplifiedData
import and.degilevich.dream.shared.feature.album.source.api.local.mapper.AlbumSimplifiedDataToEntityMapper

internal class AlbumSimplifiedDataToEntityMapperImpl : AlbumSimplifiedDataToEntityMapper {

    override fun map(item: AlbumSimplifiedData): AlbumEntity = with(item) {
        AlbumEntity(
            id = id.value,
            name = name,
            albumType = albumType.id.value,
            totalTracks = totalTracks,
            releaseDate = releaseDate
        )
    }
}