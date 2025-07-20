package and.degilevich.dream.shated.feature.track.design.api.mapper

import and.degilevich.dream.shared.feature.track.model.artifact.api.abstraction.TrackInfo
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shated.feature.track.design.api.model.TrackCardUIData

interface TrackInfoToTrackCardUIDataMapper : Mapper<TrackInfo, TrackCardUIData>