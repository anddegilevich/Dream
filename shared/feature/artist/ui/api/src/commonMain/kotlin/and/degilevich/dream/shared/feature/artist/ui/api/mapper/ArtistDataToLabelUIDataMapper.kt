package and.degilevich.dream.shared.feature.artist.ui.api.mapper

import and.degilevich.dream.shared.feature.artist.ui.api.model.ArtistLabelUIData
import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface ArtistDataToLabelUIDataMapper : Mapper<ArtistData, ArtistLabelUIData>