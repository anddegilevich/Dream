package and.degilevich.dream.shared.feature.track.source.api.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.data.track.TrackOutput
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface TrackOutputToDataMapper : Mapper<TrackOutput, TrackData>