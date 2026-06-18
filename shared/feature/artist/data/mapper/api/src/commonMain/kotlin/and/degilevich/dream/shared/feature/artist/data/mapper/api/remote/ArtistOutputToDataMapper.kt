package and.degilevich.dream.shared.feature.artist.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.generated.model.ArtistObject
import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface ArtistOutputToDataMapper : Mapper<ArtistObject, ArtistData>