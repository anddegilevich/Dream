package and.degilevich.dream.shared.feature.artist.model.core.api.mapper

import and.degilevich.dream.shared.core.service.api.requests.getArtistRelatedArtists.GetArtistRelatedArtistsRequest
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtistRelatedArtists.GetArtistRelatedArtistsParams
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetArtistRelatedArtistsParamsToRequestMapper :
    Mapper<GetArtistRelatedArtistsParams, GetArtistRelatedArtistsRequest>
