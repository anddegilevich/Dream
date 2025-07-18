package and.degilevich.dream.shared.feature.artist.model.core.api.mapper

import and.degilevich.dream.shared.core.service.api.requests.getArtist.GetArtistResponse
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtist.GetArtistResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetArtistResponseToResultMapper : Mapper<GetArtistResponse, GetArtistResult>