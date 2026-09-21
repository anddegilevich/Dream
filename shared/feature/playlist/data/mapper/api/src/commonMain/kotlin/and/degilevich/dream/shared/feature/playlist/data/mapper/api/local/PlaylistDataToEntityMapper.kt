package and.degilevich.dream.shared.feature.playlist.data.mapper.api.local

import and.degilevich.dream.shared.core.db.api.entity.PlaylistEntity
import and.degilevich.dream.shared.feature.playlist.model.core.api.data.PlaylistData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface PlaylistDataToEntityMapper : Mapper<PlaylistData, PlaylistEntity>
