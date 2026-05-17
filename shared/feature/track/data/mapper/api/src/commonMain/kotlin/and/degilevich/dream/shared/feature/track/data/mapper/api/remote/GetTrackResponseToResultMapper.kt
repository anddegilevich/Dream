package and.degilevich.dream.shared.feature.track.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.model.method.getTrack.GetTrackResponse
import and.degilevich.dream.shared.feature.track.model.core.method.getTrack.GetTrackResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetTrackResponseToResultMapper : Mapper<GetTrackResponse, GetTrackResult>