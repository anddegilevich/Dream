package and.degilevich.dream.shared.feature.track.source.api.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getTrack.GetTrackRequest
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackParams
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetTrackParamsToRequestMapper : Mapper<GetTrackParams, GetTrackRequest>