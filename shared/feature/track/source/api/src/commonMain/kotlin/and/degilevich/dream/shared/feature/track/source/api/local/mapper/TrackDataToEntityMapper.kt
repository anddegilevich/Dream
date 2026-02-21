package and.degilevich.dream.shared.feature.track.source.api.local.mapper

import and.degilevich.dream.shared.core.db.api.entity.TrackEntity
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface TrackDataToEntityMapper : Mapper<TrackData, TrackEntity>