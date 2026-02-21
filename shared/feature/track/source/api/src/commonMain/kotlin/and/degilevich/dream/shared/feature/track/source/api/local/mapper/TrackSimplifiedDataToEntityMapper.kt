package and.degilevich.dream.shared.feature.track.source.api.local.mapper

import and.degilevich.dream.shared.core.db.api.entity.TrackEntity
import and.degilevich.dream.shared.feature.track.model.artifact.api.data.TrackSimplifiedData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface TrackSimplifiedDataToEntityMapper : Mapper<TrackSimplifiedData, TrackEntity>