package and.degilevich.dream.shared.feature.artist.model.core.api.mapper

import and.degilevich.dream.shared.core.service.api.core.artist.ArtistFollowersOutput
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistFollowersData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface ArtistFollowersOutputToDataMapper : Mapper<ArtistFollowersOutput, ArtistFollowersData>