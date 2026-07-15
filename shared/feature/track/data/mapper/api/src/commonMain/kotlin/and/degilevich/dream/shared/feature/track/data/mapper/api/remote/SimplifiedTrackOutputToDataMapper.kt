package and.degilevich.dream.shared.feature.track.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.generated.model.SimplifiedTrackObject
import and.degilevich.dream.shared.feature.track.model.artifact.data.SimplifiedTrackData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface SimplifiedTrackOutputToDataMapper : Mapper<SimplifiedTrackObject, SimplifiedTrackData>