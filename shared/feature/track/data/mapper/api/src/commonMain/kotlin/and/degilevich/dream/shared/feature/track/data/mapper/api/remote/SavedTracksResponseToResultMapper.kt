package and.degilevich.dream.shared.feature.track.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PagingSavedTrackObject
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface SavedTracksResponseToResultMapper : Mapper<PagingSavedTrackObject, GetSavedTracksResult>
