package and.degilevich.dream.shared.feature.album.source.api.local.mapper

import and.degilevich.dream.shared.core.db.api.entity.AlbumEntity
import and.degilevich.dream.shared.feature.album.model.core.api.data.AlbumData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface AlbumDataToEntityMapper : Mapper<AlbumData, AlbumEntity>