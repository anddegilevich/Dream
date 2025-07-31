package and.degilevich.dream.shared.feature.search.design.api.mapper

import and.degilevich.dream.shared.feature.search.design.api.model.card.TrackSearchCardUIData
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface TrackDataToSearchCardUIDataMapper : Mapper<TrackData, TrackSearchCardUIData>