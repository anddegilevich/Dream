package and.degilevich.dream.shared.feature.artist.model.core.api.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getArtists.GetArtistsRequest
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtists.GetArtistsParams
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetArtistsParamsToRequestMapper : Mapper<GetArtistsParams, GetArtistsRequest>