package and.degilevich.dream.shared.feature.playlist.data.mapper.test.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PagingPlaylistTrackObject
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.remote.PlaylistTracksResponseToResultMapper
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylistTracks.GetPlaylistTracksResult
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakePlaylistTracksResponseToResultMapper(
    private val onMap: (PagingPlaylistTrackObject) -> GetPlaylistTracksResult = { fakeImplementationError() }
) : PlaylistTracksResponseToResultMapper {

    override fun map(item: PagingPlaylistTrackObject): GetPlaylistTracksResult = onMap(item)
}
