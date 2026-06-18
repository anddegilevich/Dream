package and.degilevich.dream.shared.feature.track.data.mapper.api.local

import and.degilevich.dream.shared.core.db.api.entity.TrackEntity
import and.degilevich.dream.shared.feature.track.model.artifact.data.SimplifiedTrackData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface SimplifiedTrackDataToEntityMapper : Mapper<SimplifiedTrackData, TrackEntity>