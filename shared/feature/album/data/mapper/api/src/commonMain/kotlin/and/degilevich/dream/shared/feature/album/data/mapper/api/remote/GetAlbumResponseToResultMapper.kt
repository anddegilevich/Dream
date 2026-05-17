package and.degilevich.dream.shared.feature.album.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.model.method.getAlbum.GetAlbumResponse
import and.degilevich.dream.shared.feature.album.model.core.method.getAlbum.GetAlbumResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetAlbumResponseToResultMapper : Mapper<GetAlbumResponse, GetAlbumResult>