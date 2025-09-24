package and.degilevich.dream.shared.feature.artist.source.api.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.data.artist.ArtistOutput
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface ArtistOutputToDataMapper : Mapper<ArtistOutput, ArtistData>