package and.degilevich.dream.shared.feature.track.model.core.api.mapper

import and.degilevich.dream.shared.core.service.api.requests.getTrack.GetTrackRequest
import and.degilevich.dream.shared.feature.track.model.core.api.request.getTrack.GetTrackParams
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetTrackParamsToRequestMapper : Mapper<GetTrackParams, GetTrackRequest>