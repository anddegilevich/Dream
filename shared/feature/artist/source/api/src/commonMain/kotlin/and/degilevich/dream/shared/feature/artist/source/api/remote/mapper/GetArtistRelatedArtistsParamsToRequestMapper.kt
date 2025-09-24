package and.degilevich.dream.shared.feature.artist.source.api.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getArtistRelatedArtists.GetArtistRelatedArtistsRequest
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistRelatedArtists.GetArtistRelatedArtistsParams
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetArtistRelatedArtistsParamsToRequestMapper :
    Mapper<GetArtistRelatedArtistsParams, GetArtistRelatedArtistsRequest>
