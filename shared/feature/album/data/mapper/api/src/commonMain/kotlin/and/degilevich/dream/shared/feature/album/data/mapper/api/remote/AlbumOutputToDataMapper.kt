package and.degilevich.dream.shared.feature.album.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.generated.model.AlbumObject
import and.degilevich.dream.shared.feature.album.model.core.data.AlbumData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface AlbumOutputToDataMapper : Mapper<AlbumObject, AlbumData>