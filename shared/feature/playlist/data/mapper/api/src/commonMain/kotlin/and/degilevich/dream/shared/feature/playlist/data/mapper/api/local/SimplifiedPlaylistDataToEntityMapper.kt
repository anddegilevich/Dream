package and.degilevich.dream.shared.feature.playlist.data.mapper.api.local

import and.degilevich.dream.shared.core.db.api.entity.PlaylistEntity
import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.SimplifiedPlaylistData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface SimplifiedPlaylistDataToEntityMapper : Mapper<SimplifiedPlaylistData, PlaylistEntity>
