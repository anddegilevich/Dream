package and.degilevich.dream.shared.feature.track.data.mapper.api.local

import and.degilevich.dream.shared.core.db.api.entity.TrackEntity
import and.degilevich.dream.shared.feature.track.model.core.data.TrackData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface TrackDataToEntityMapper : Mapper<TrackData, TrackEntity>