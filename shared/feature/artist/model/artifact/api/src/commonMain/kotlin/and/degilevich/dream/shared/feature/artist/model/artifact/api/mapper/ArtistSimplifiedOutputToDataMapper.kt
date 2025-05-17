package and.degilevich.dream.shared.feature.artist.model.artifact.api.mapper

import and.degilevich.dream.shared.core.service.api.model.artist.ArtistSimplifiedOutput
import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.ArtistSimplifiedData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface ArtistSimplifiedOutputToDataMapper : Mapper<ArtistSimplifiedOutput, ArtistSimplifiedData>