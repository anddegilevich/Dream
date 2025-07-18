package and.degilevich.dream.shared.feature.artist.model.core.api.mapper

import and.degilevich.dream.shared.core.service.api.requests.getArtistRelatedArtists.GetArtistRelatedArtistsResponse
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtistRelatedArtists.GetArtistRelatedArtistsResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetArtistRelatedArtistsResponseToResultMapper :
    Mapper<GetArtistRelatedArtistsResponse, GetArtistRelatedArtistsResult>