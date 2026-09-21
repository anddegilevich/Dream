package and.degilevich.dream.shared.feature.playlist.data.mapper.test.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PlaylistTrackObject
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.remote.PlaylistTrackOutputToDataMapper
import and.degilevich.dream.shared.feature.playlist.model.core.api.data.PlaylistTrackData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakePlaylistTrackOutputToDataMapper(
    private val onMap: (PlaylistTrackObject) -> PlaylistTrackData = { fakeImplementationError() }
) : PlaylistTrackOutputToDataMapper {

    override fun map(item: PlaylistTrackObject): PlaylistTrackData = onMap(item)
}
