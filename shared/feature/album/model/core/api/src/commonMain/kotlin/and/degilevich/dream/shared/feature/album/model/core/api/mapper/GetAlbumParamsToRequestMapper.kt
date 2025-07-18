package and.degilevich.dream.shared.feature.album.model.core.api.mapper

import and.degilevich.dream.shared.core.service.api.requests.getAlbum.GetAlbumRequest
import and.degilevich.dream.shared.feature.album.model.core.api.request.getAlbum.GetAlbumParams
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetAlbumParamsToRequestMapper : Mapper<GetAlbumParams, GetAlbumRequest>