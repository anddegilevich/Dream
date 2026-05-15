package and.degilevich.dream.shared.feature.artist.data.api.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getArtist.GetArtistRequest
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtist.GetArtistParams
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetArtistParamsToRequestMapper : Mapper<GetArtistParams, GetArtistRequest>