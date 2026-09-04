package and.degilevich.dream.shared.feature.playlist.data.mapper.test.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PlaylistObject
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.remote.PlaylistOutputToDataMapper
import and.degilevich.dream.shared.feature.playlist.model.core.api.data.PlaylistData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakePlaylistOutputToDataMapper(
    private val onMap: (PlaylistObject) -> PlaylistData = { fakeImplementationError() }
) : PlaylistOutputToDataMapper {

    override fun map(item: PlaylistObject): PlaylistData = onMap(item)
}
