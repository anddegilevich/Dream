package and.degilevich.dream.shared.feature.track.model.artifact.api.mapper

import and.degilevich.dream.shared.core.service.api.model.track.TrackSimplifiedOutput
import and.degilevich.dream.shared.feature.track.model.artifact.api.data.TrackSimplifiedData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface TrackSimplifiedOutputToDataMapper : Mapper<TrackSimplifiedOutput, TrackSimplifiedData>