package and.degilevich.dream.shared.feature.artist.data.api.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.data.artist.ArtistOutput
import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface ArtistOutputToDataMapper : Mapper<ArtistOutput, ArtistData>