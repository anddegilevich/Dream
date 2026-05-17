package and.degilevich.dream.shared.feature.track.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.model.method.getTrack.GetTrackRequest
import and.degilevich.dream.shared.feature.track.model.core.method.getTrack.GetTrackParams
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetTrackParamsToRequestMapper : Mapper<GetTrackParams, GetTrackRequest>