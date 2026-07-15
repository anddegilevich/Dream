package and.degilevich.dream.shared.feature.album.data.mapper.api.local

import and.degilevich.dream.shared.core.db.api.entity.AlbumEntity
import and.degilevich.dream.shared.feature.album.model.artifact.data.SimplifiedAlbumData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface SimplifiedAlbumDataToEntityMapper : Mapper<SimplifiedAlbumData, AlbumEntity>