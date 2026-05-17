package and.degilevich.dream.shared.feature.artist.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.model.method.getArtist.GetArtistResponse
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtist.GetArtistResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetArtistResponseToResultMapper : Mapper<GetArtistResponse, GetArtistResult>