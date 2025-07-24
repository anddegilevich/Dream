package and.degilevich.dream.shared.feature.artist.model.core.api.mapper

import and.degilevich.dream.shared.core.service.api.requests.getArtistAlbums.GetArtistAlbumsRequest
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtistAlbums.GetArtistAlbumsParams
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetArtistAlbumsParamsToRequestMapper : Mapper<GetArtistAlbumsParams, GetArtistAlbumsRequest>