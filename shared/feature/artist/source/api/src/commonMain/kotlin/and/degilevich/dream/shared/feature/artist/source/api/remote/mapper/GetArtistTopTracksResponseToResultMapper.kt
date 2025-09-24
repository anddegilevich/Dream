package and.degilevich.dream.shared.feature.artist.source.api.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getArtistTopTracks.GetArtistTopTracksResponse
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistTopTracks.GetArtistTopTracksResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetArtistTopTracksResponseToResultMapper : Mapper<GetArtistTopTracksResponse, GetArtistTopTracksResult>