package and.degilevich.dream.shared.feature.playlist.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PagingPlaylistTrackObject
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylistTracks.GetPlaylistTracksResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface PlaylistTracksResponseToResultMapper : Mapper<PagingPlaylistTrackObject, GetPlaylistTracksResult>
