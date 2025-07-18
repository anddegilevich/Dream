package and.degilevich.dream.shared.feature.artist.model.core.api.mapper

import and.degilevich.dream.shared.core.service.api.requests.getArtist.GetArtistRequest
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtist.GetArtistParams
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetArtistParamsToRequestMapper : Mapper<GetArtistParams, GetArtistRequest>