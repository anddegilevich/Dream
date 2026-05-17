package and.degilevich.dream.shated.feature.track.ui.api.mapper

import and.degilevich.dream.shared.feature.track.model.artifact.abstraction.TrackInfo
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shated.feature.track.ui.api.model.TrackCardUIData

interface TrackInfoToTrackCardUIDataMapper : Mapper<TrackInfo, TrackCardUIData>