package and.degilevich.dream.shared.feature.search.ui.api.mapper

import and.degilevich.dream.shared.feature.search.ui.api.model.card.TrackSearchCardUIData
import and.degilevich.dream.shared.feature.track.model.core.data.TrackData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface TrackDataToSearchCardUIDataMapper : Mapper<TrackData, TrackSearchCardUIData>