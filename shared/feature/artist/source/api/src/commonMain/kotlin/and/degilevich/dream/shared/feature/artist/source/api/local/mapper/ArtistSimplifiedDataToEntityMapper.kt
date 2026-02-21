package and.degilevich.dream.shared.feature.artist.source.api.local.mapper

import and.degilevich.dream.shared.core.db.api.entity.ArtistEntity
import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.ArtistSimplifiedData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface ArtistSimplifiedDataToEntityMapper : Mapper<ArtistSimplifiedData, ArtistEntity>