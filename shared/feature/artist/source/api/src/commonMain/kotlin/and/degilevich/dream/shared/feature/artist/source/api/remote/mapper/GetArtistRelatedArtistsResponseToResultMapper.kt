package and.degilevich.dream.shared.feature.artist.source.api.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getArtistRelatedArtists.GetArtistRelatedArtistsResponse
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistRelatedArtists.GetArtistRelatedArtistsResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetArtistRelatedArtistsResponseToResultMapper :
    Mapper<GetArtistRelatedArtistsResponse, GetArtistRelatedArtistsResult>