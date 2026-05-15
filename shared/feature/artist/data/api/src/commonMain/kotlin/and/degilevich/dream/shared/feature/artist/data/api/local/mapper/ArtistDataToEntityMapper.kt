package and.degilevich.dream.shared.feature.artist.data.api.local.mapper

import and.degilevich.dream.shared.core.db.api.entity.ArtistEntity
import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface ArtistDataToEntityMapper : Mapper<ArtistData, ArtistEntity>