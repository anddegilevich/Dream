package and.degilevich.dream.shared.feature.artist.model.core.api.mapper

import and.degilevich.dream.shared.core.service.api.requests.getArtistTopTracks.GetArtistTopTracksResponse
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtistTopTracks.GetArtistTopTracksResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetArtistTopTracksResponseToResultMapper : Mapper<GetArtistTopTracksResponse, GetArtistTopTracksResult>