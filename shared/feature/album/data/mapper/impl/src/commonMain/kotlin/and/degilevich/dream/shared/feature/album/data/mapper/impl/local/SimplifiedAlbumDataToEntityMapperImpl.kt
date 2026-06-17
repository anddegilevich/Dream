package and.degilevich.dream.shared.feature.album.data.mapper.impl.local

import and.degilevich.dream.shared.core.db.api.entity.AlbumEntity
import and.degilevich.dream.shared.feature.album.data.mapper.api.local.SimplifiedAlbumDataToEntityMapper
import and.degilevich.dream.shared.feature.album.model.artifact.data.SimplifiedAlbumData

internal class SimplifiedAlbumDataToEntityMapperImpl : SimplifiedAlbumDataToEntityMapper {

    override fun map(item: SimplifiedAlbumData): AlbumEntity = with(item) {
        AlbumEntity(
            id = id.value,
            name = name,
            albumType = albumType.id.value,
            totalTracks = totalTracks,
            releaseDate = releaseDate
        )
    }
}