package and.degilevich.dream.shared.feature.artist.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.model.data.artist.ArtistSimplifiedOutput
import and.degilevich.dream.shared.feature.artist.model.artifact.data.ArtistSimplifiedData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface ArtistSimplifiedOutputToDataMapper : Mapper<ArtistSimplifiedOutput, ArtistSimplifiedData>