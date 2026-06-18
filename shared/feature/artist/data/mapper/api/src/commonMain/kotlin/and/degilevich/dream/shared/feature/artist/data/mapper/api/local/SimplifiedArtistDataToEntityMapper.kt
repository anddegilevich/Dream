package and.degilevich.dream.shared.feature.artist.data.mapper.api.local

import and.degilevich.dream.shared.core.db.api.entity.ArtistEntity
import and.degilevich.dream.shared.feature.artist.model.artifact.data.SimplifiedArtistData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface SimplifiedArtistDataToEntityMapper : Mapper<SimplifiedArtistData, ArtistEntity>