package and.degilevich.dream.shared.feature.track.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.model.data.track.TrackOutput
import and.degilevich.dream.shared.feature.track.model.core.data.TrackData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface TrackOutputToDataMapper : Mapper<TrackOutput, TrackData>