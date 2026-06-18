package and.degilevich.dream.shared.feature.track.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.generated.model.TrackObject
import and.degilevich.dream.shared.feature.track.model.core.data.TrackData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface TrackOutputToDataMapper : Mapper<TrackObject, TrackData>