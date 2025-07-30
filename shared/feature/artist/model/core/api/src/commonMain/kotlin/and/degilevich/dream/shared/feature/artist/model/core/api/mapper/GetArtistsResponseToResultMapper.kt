package and.degilevich.dream.shared.feature.artist.model.core.api.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getArtists.GetArtistsResponse
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtists.GetArtistsResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetArtistsResponseToResultMapper : Mapper<GetArtistsResponse, GetArtistsResult>