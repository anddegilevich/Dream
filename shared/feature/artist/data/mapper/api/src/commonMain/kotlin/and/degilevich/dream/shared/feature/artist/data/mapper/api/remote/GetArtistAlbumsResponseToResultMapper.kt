package and.degilevich.dream.shared.feature.artist.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PagingArtistDiscographyAlbumObject
import and.degilevich.dream.shared.feature.artist.domain.model.core.api.method.getArtistAlbums.GetArtistAlbumsResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetArtistAlbumsResponseToResultMapper : Mapper<PagingArtistDiscographyAlbumObject, GetArtistAlbumsResult>