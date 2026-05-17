package and.degilevich.dream.shared.feature.artist.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.model.method.getArtistAlbums.GetArtistAlbumsResponse
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtistAlbums.GetArtistAlbumsResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetArtistAlbumsResponseToResultMapper : Mapper<GetArtistAlbumsResponse, GetArtistAlbumsResult>