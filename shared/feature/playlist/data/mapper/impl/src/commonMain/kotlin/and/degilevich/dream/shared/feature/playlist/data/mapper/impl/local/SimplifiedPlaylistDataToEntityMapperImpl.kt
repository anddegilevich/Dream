package and.degilevich.dream.shared.feature.playlist.data.mapper.impl.local

import and.degilevich.dream.shared.core.db.api.entity.PlaylistEntity
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.local.SimplifiedPlaylistDataToEntityMapper
import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.SimplifiedPlaylistData

internal class SimplifiedPlaylistDataToEntityMapperImpl : SimplifiedPlaylistDataToEntityMapper {

    override fun map(item: SimplifiedPlaylistData): PlaylistEntity = with(item) {
        PlaylistEntity(
            id = id.value,
            name = name,
            description = description,
            totalTracks = totalTracks
        )
    }
}
