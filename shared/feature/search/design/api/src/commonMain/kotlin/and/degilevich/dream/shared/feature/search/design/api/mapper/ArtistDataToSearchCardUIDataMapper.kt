package and.degilevich.dream.shared.feature.search.design.api.mapper

import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.search.design.api.model.card.ArtistSearchCardUIData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface ArtistDataToSearchCardUIDataMapper : Mapper<ArtistData, ArtistSearchCardUIData>