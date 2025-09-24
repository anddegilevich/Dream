package and.degilevich.dream.shared.feature.artist.source.api.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getArtistTopTracks.GetArtistTopTracksRequest
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistTopTracks.GetArtistTopTracksParams
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetArtistTopTracksParamsToRequestMapper : Mapper<GetArtistTopTracksParams, GetArtistTopTracksRequest>