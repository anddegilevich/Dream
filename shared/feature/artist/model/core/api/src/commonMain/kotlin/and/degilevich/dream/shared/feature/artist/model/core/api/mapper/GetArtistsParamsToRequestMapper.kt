package and.degilevich.dream.shared.feature.artist.model.core.api.mapper

import and.degilevich.dream.shared.core.service.api.requests.getArtists.GetArtistsRequest
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtists.GetArtistsParams
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetArtistsParamsToRequestMapper : Mapper<GetArtistsParams, GetArtistsRequest>