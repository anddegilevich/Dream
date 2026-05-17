package and.degilevich.dream.shared.feature.track.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.model.data.track.TrackSimplifiedOutput
import and.degilevich.dream.shared.feature.track.model.artifact.data.TrackSimplifiedData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface TrackSimplifiedOutputToDataMapper : Mapper<TrackSimplifiedOutput, TrackSimplifiedData>