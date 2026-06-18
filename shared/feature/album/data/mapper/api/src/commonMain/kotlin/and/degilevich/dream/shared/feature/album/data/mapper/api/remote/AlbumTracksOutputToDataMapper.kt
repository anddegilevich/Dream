package and.degilevich.dream.shared.feature.album.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PagingSimplifiedTrackObject
import and.degilevich.dream.shared.feature.album.model.core.data.AlbumTracksData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface AlbumTracksOutputToDataMapper : Mapper<PagingSimplifiedTrackObject, AlbumTracksData>