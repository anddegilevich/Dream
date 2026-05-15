package and.degilevich.dream.shared.feature.album.data.api.local.mapper

import and.degilevich.dream.shared.core.db.api.entity.AlbumEntity
import and.degilevich.dream.shared.feature.album.model.artifact.data.AlbumSimplifiedData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface AlbumSimplifiedDataToEntityMapper : Mapper<AlbumSimplifiedData, AlbumEntity>