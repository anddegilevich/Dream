package and.degilevich.dream.shared.feature.album.model.core.api.mapper

import and.degilevich.dream.shared.core.service.api.requests.getAlbum.GetAlbumResponse
import and.degilevich.dream.shared.feature.album.model.core.api.request.getAlbum.GetAlbumResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetAlbumResponseToResultMapper : Mapper<GetAlbumResponse, GetAlbumResult>