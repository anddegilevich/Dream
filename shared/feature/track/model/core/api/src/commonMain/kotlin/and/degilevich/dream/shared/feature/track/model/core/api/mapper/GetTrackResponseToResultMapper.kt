package and.degilevich.dream.shared.feature.track.model.core.api.mapper

import and.degilevich.dream.shared.core.service.api.requests.getTrack.GetTrackResponse
import and.degilevich.dream.shared.feature.track.model.core.api.request.getTrack.GetTrackResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetTrackResponseToResultMapper : Mapper<GetTrackResponse, GetTrackResult>