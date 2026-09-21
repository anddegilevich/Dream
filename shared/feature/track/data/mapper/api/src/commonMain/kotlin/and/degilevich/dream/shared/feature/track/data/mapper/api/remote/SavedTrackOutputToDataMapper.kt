package and.degilevich.dream.shared.feature.track.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.generated.model.SavedTrackObject
import and.degilevich.dream.shared.feature.track.model.core.api.data.SavedTrackData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface SavedTrackOutputToDataMapper : Mapper<SavedTrackObject, SavedTrackData>
