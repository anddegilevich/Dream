package and.degilevich.dream.shared.feature.artist.model.core.api.mapper

import and.degilevich.dream.shared.core.service.api.requests.getArtistAlbums.GetArtistAlbumsResponse
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtistAlbums.GetArtistAlbumsResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetArtistAlbumsResponseToResultMapper : Mapper<GetArtistAlbumsResponse, GetArtistAlbumsResult>