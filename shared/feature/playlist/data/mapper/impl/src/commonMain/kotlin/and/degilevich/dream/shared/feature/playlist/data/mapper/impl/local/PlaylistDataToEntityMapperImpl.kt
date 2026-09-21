package and.degilevich.dream.shared.feature.playlist.data.mapper.impl.local

import and.degilevich.dream.shared.core.db.api.entity.PlaylistEntity
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.local.PlaylistDataToEntityMapper
import and.degilevich.dream.shared.feature.playlist.model.core.api.data.PlaylistData

internal class PlaylistDataToEntityMapperImpl : PlaylistDataToEntityMapper {

    override fun map(item: PlaylistData): PlaylistEntity = with(item) {
        PlaylistEntity(
            id = id.value,
            name = name,
            description = description,
            totalTracks = totalTracks
        )
    }
}
