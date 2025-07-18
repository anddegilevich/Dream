package and.degilevich.dream.shared.feature.artist.model.core.api.mapper

import and.degilevich.dream.shared.core.service.api.requests.getArtistTopTracks.GetArtistTopTracksRequest
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtistTopTracks.GetArtistTopTracksParams
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetArtistTopTracksParamsToRequestMapper : Mapper<GetArtistTopTracksParams, GetArtistTopTracksRequest>