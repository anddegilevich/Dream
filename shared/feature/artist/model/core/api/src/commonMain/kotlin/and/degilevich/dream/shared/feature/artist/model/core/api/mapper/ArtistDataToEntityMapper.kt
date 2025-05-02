package and.degilevich.dream.shared.feature.artist.model.core.api.mapper

import and.degilevich.dream.shared.core.db.api.feature.artist.entity.ArtistEntity
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface ArtistDataToEntityMapper : Mapper<ArtistData, ArtistEntity>