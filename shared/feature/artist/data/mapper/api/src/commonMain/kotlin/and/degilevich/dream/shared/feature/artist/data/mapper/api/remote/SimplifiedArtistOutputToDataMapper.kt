package and.degilevich.dream.shared.feature.artist.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.generated.model.SimplifiedArtistObject
import and.degilevich.dream.shared.feature.artist.model.artifact.data.SimplifiedArtistData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface SimplifiedArtistOutputToDataMapper : Mapper<SimplifiedArtistObject, SimplifiedArtistData>