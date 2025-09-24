package and.degilevich.dream.shared.feature.album.source.api.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getAlbum.GetAlbumRequest
import and.degilevich.dream.shared.feature.album.model.core.api.method.getAlbum.GetAlbumParams
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetAlbumParamsToRequestMapper : Mapper<GetAlbumParams, GetAlbumRequest>