package and.degilevich.dream.shared.feature.album.source.impl.local.mapper

import and.degilevich.dream.shared.core.db.api.entity.AlbumEntity
import and.degilevich.dream.shared.feature.album.model.core.data.AlbumData
import and.degilevich.dream.shared.feature.album.source.api.local.mapper.AlbumDataToEntityMapper

internal class AlbumDataToEntityMapperImpl : AlbumDataToEntityMapper {

    override fun map(item: AlbumData): AlbumEntity = with(item) {
        AlbumEntity(
            id = id.value,
            name = name,
            albumType = albumType.id.value,
            totalTracks = totalTracks,
            releaseDate = releaseDate
        )
    }
}