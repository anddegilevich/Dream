package and.degilevich.dream.shared.feature.artist.model.core.api.mapper

import and.degilevich.dream.shared.core.service.api.requests.getArtists.GetArtistsResponse
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtists.GetArtistsResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetArtistsResponseToResultMapper : Mapper<GetArtistsResponse, GetArtistsResult>